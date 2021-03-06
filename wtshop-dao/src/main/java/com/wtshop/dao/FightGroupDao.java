package com.wtshop.dao;

import com.wtshop.model.FightGroup;
import com.wtshop.model.FudaiProduct;
import org.jsoup.helper.StringUtil;

import java.util.List;

/**
 * Created by 蔺哲 on 2017/7/11.
 */
public class FightGroupDao extends BaseDao<FightGroup> {
    public FightGroupDao(){super(FightGroup.class);}


    /**
     * 根据商品id   product_id 获取参团信息
     */
    public List<FightGroup> findByProductId(Long productId){
        String sql = "select f.*,m.`nickname`,m.avatar from fight_group f LEFT JOIN member m  on f.member_id=m.id where  f.groupnum>f.count  and f.product_id="+productId+ " order by f.groupnum-f.count ";
        return modelManager.find(sql);
    }    /**
     * 根据商品id   product_id 获取参团信息
     */
    public List<FightGroup> findByGroupBuyId(Long groupBuyId){
        String sql = "select f.*,m.`nickname`,m.avatar from fight_group f LEFT JOIN member m  on f.member_id=m.id where  f.groupnum>f.count  and f.tuangou_id="+groupBuyId+ " order by f.groupnum-f.count ";
        return modelManager.find(sql);
    }


    /**
     *根据福袋查询对应的副产品
     * @param fuDaiId
     * @return
     */
    public List<FightGroup> findByFudaiId(Long fuDaiId){
       String sql = "select * from fudai_product where is_main=0 AND fudai_id="+fuDaiId;
       return modelManager.find(sql);
    }
    public FightGroup findMainByFuDaiId(Long fuDaiId){
        String sql = "select * from fudai_product where is_main=1 AND fudai_id="+fuDaiId;
        return modelManager.findFirst(sql);
    }

    /**
     * 根据福袋id 查询主商品信息
     */
    public FightGroup findPrimary(Long id){
        if(id == null){
            return null;
        }else {
            String sql = "select f.id,f.probability ,f.repeatTime ,f.is_main ,f.product_id ,g.`name` ,g.image FROM fudai_product f LEFT JOIN product p on f.product_id = p.id LEFT JOIN goods g on g.id = p.goods_id where f.is_main = 1 AND f.fudai_id =" + id;
            return modelManager.findFirst(sql);
        }

    }

    /**
     * 根据福袋id 查询所有商品信息
     */
    public List<FightGroup> findMessage(Long id){
        if(id == null){
            return null;
        }else {
            String sql = "select f.id, f.probability ,f.repeatTime ,f.is_main ,p.id as productId ,g.`name` ,g.image FROM fudai_product f LEFT JOIN product p on f.product_id = p.id LEFT JOIN goods g on g.id = p.goods_id where f.fudai_id =" + id;
            return modelManager.find(sql);
        }

    }

    /**
     * 根据福袋id 查询副商品信息
     */
    public List<FightGroup> findByPro(Long id , List<Long> productIdList){
        String sql =  "select f.id, f.probability ,f.repeatTime ,f.is_main ,f.product_id ,g.`name` ,g.image FROM fudai_product f LEFT JOIN product p on f.product_id = p.id LEFT JOIN goods g on g.id = p.goods_id  where 1 = 1 and f.is_main = 0";
        if (id != null){

            sql += " AND f.fudai_id =" + id ;

        }
        if(productIdList.size() > 0){

            sql += " AND f.product_id not in (" + StringUtil.join(productIdList,",") + ")";

        }
        return modelManager.find(sql);
    }


    //检测库存
}
