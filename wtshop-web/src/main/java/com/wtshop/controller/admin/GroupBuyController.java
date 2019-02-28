package com.wtshop.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.upload.UploadFile;
import com.wtshop.Message;
import com.wtshop.Pageable;
import com.wtshop.entity.ProductImage;
import com.wtshop.model.*;
import com.wtshop.service.*;
import com.wtshop.util.ApiResult;
import com.wtshop.util.ReadProper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Created by mrFeng on 2019/2/18
 * 团购管理
 */
@ControllerBind(controllerKey = "/admin/groupBuy")
public class GroupBuyController extends BaseController {
    private GroupBuyService fuDaiService = enhance(GroupBuyService.class);
    public void list() {

        GroupBuy fuDai = fuDaiService.find(23L);



        Pageable pageable = getBean(Pageable.class);
        pageable.setOrderProperty("orders");
        pageable.setOrderDirection("desc");
        setAttr("pageable", pageable);
        setAttr("page", fuDaiService.findPage(pageable));
        render("/admin/groupBuy/list.ftl");
    }

    //去添加页面
    public void add() {

        render("/admin/groupBuy/add.ftl");
    }

    //保存福袋信息
    public void save() {
        List<UploadFile> uploadFiles = getFiles();
        GroupBuy groupBuy = getModel( GroupBuy.class);
        Map<String, String[]> sssss = getParaMap();

        Long productId = getParaToLong("productId");
        groupBuy.setProductId(productId);
        groupBuy.setStatus(getParaToBoolean("status", false));
        groupBuy.setIsList(getParaToBoolean("isList", false));
        groupBuy.setIsTop(getParaToBoolean("isTop", false));
        groupBuy.setIsSinglepurchase(getParaToBoolean("isSinglepurchase", false));

        fuDaiService.save(groupBuy);
        FudaiProduct fudaiProduct = new FudaiProduct(productId, groupBuy.getId(), 1);
        redirect("/admin/groupBuy/list.jhtml");
    }

    //去修改页面
    public void toEdit() {
        Long fuDaiId = getParaToLong("id");
        GroupBuy group = fuDaiService.find(fuDaiId);
        setAttr("groupBuy", group);

        render("/admin/groupBuy/edit.ftl");
    }

    //修改福袋信息
    public void edit() {
        // 图片
        List<UploadFile> uploadFiles = getFiles();
        Map<String, String[]> sssss = getParaMap();
        Map<String, String[]> dddd = getRequest().getParameterMap();
        GroupBuy fuDai = getModel( GroupBuy.class);

        fuDai.setStatus(getParaToBoolean("status", false));
        fuDai.setIsList(getParaToBoolean("isList", false));
        fuDai.setIsTop(getParaToBoolean("isTop", false));
        fuDai.setIsSinglepurchase(getParaToBoolean("isSinglepurchase", false));
        Long productId = getParaToLong("productId");
        fuDai.setProductId(productId);
        fuDaiService.update(fuDai);

        redirect("/admin/groupBuy/list.jhtml");
    }

    //删除福袋
    public void delete() {
        Long[] ids = getParaValuesToLong("ids");
        fuDaiService.delete(ids);


        renderJson("type", "success");
    }

    public void status() {
        Long id = getParaToLong("fudaiId");
        int status = getParaToInt("status");
        GroupBuy fuDai = fuDaiService.find(id);
        fuDai.setStatus(status);
        fuDaiService.update(fuDai);
        renderJson("1");
    }

    public void addGoods() {
        Long fuDaiId = getParaToLong("id");
        List list = fuDaiService.queryByFuDaiId(fuDaiId);
        GroupBuy fd = fuDaiService.find(fuDaiId);
        setAttr("fuDaiId", fuDaiId);
        setAttr("indexNum", list.size());
        setAttr("fuDaiProductList", list);
        setAttr("fd", fd);
        render("/admin/groupBuy/addGoods.ftl");
    }

    public void saveGoogs() {
        List<FudaiProduct> list = getModels(FudaiProduct.class);
        Long fuDaiId = getParaToLong("fuDaiId");
        fuDaiService.saveOrUpdate(list, fuDaiId);
        redirect("/admin/groupBuy/list.jhtml");
    }

    public void imgList() {
        long fudaiId = getParaToLong("id");
        setAttr("fudaiId", fudaiId);

        render("/admin/groupBuy/imglist.ftl");

    }



    public void delImg() {

        renderJson(ApiResult.success());
    }

    /**
     * 禁用福袋
     */
    public void disabled() {
        Long fudaiId = getParaToLong("id");
        GroupBuy fuDai = fuDaiService.find(fudaiId);
        fuDai.setStatus(FuDai.State_UnActive);
        fuDaiService.update(fuDai);
        redirect("list.jhtml");
    }


    /**
     * 启用福袋
     */
    public void publish() {
        Long fudaiId = getParaToLong("id");
        GroupBuy fuDai = fuDaiService.find(fudaiId);
        List<FudaiProduct> list = fuDaiService.findSubListByFudaiId(fuDai.getId());
        if (CollectionUtils.isEmpty(list) || list.size() <= fuDai.getNum()) {
            addFlashMessage(Message.errMsg("福袋副产品数量需要大于福袋要抽取的副产品数量"));
            redirect("list.jhtml");
            return;
        }
        fuDai.setStatus(FuDai.State_Active);
        fuDaiService.update(fuDai);
        redirect("list.jhtml");
    }


}
