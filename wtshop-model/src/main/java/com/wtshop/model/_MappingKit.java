package com.wtshop.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * Generated by JFinal, do not modify this file.
 * <pre>
 * Example:
 * public void configPlugin(Plugins me) {
 *     ActiveRecordPlugin arp = new ActiveRecordPlugin(...);
 *     _MappingKit.mapping(arp);
 *     me.add(arp);
 * }
 * </pre>
 */
public class _MappingKit {

	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("special_coupon", "id", SpecialCoupon.class);
		arp.addMapping("account", "id", Account.class);
		arp.addMapping("full_reduction", "id", FullReduction.class);
		arp.addMapping("special_goods", "id", SpecialGoods.class);
		arp.addMapping("identifier", "id", Identifier.class);
		arp.addMapping("act_introduce", "id", ActIntroduce.class);
		arp.addMapping("activity", "id", Activity.class);
		arp.addMapping("activity_product", "id", ActivityProduct.class);
		arp.addMapping("ad", "id", Ad.class);
		arp.addMapping("ad_position", "id", AdPosition.class);
		arp.addMapping("admin", "id", Admin.class);
		// Composite Primary Key order: admins,roles
		arp.addMapping("admin_role", "admins,roles", AdminRole.class);
		arp.addMapping("appManage", "id", AppManage.class);
		arp.addMapping("app_version", "id", AppVersion.class);
		arp.addMapping("area", "id", Area.class);
		arp.addMapping("area_describe", "id", AreaDescribe.class);
		arp.addMapping("article", "id", Article.class);
		arp.addMapping("article_category", "id", ArticleCategory.class);
		// Composite Primary Key order: articles,tags
		arp.addMapping("article_tag", "articles,tags", ArticleTag.class);
		arp.addMapping("attribute", "id", Attribute.class);
		arp.addMapping("bargain", "id", Bargain.class);
		arp.addMapping("bargain_detail", "id", BargainDetail.class);
		arp.addMapping("bargain_help", "id", BargainHelp.class);
		arp.addMapping("bargain_personal", "id", BargainPersonal.class);
		arp.addMapping("brand", "id", Brand.class);
		arp.addMapping("butler_upgrade_log", "id", ButlerUpgradeLog.class);
		arp.addMapping("cart", "id", Cart.class);
		arp.addMapping("cart_item", "id", CartItem.class);
		arp.addMapping("certificates", "id", Certificates.class);
		arp.addMapping("character_commend", "id", CharacterCommend.class);
		arp.addMapping("comm_exchange_progress", "id", CommExchangeProgress.class);
		arp.addMapping("commission_history", "id", CommissionHistory.class);
		arp.addMapping("commission_log", "id", CommissionLog.class);
		arp.addMapping("consultation", "id", Consultation.class);
		arp.addMapping("coupon", "id", Coupon.class);
		arp.addMapping("coupon_code", "id", CouponCode.class);
		arp.addMapping("coupon_share", "id", CouponShare.class);
		arp.addMapping("delivery_center", "id", DeliveryCenter.class);
		arp.addMapping("delivery_corp", "id", DeliveryCorp.class);
		arp.addMapping("delivery_template", "id", DeliveryTemplate.class);
		arp.addMapping("deposit_log", "id", DepositLog.class);
		arp.addMapping("effect", "id", Effect.class);
		arp.addMapping("exchange_log", "id", ExchangeLog.class);
		arp.addMapping("exchange_progress", "id", ExchangeProgress.class);
		arp.addMapping("feedback", "id", Feedback.class);
		arp.addMapping("fight_group", "id", FightGroup.class);
		arp.addMapping("flashsale", "id", Flashsale.class);
		arp.addMapping("flashsale_detail", "id", FlashsaleDetail.class);
		arp.addMapping("footprint", "id", Footprint.class);
		arp.addMapping("free_apply", "id", FreeApply.class);
		arp.addMapping("free_use", "id", FreeUse.class);
		arp.addMapping("freight_config", "id", FreightConfig.class);
		arp.addMapping("friend_link", "id", FriendLink.class);
		arp.addMapping("fu_dai", "id", FuDai.class);
		arp.addMapping("fudai_img", "id", FudaiImg.class);
		arp.addMapping("fudai_product", "id", FudaiProduct.class);
		arp.addMapping("function", "id", Function.class);
		arp.addMapping("goods", "id", Goods.class);
		// Composite Primary Key order: effect,goods
		arp.addMapping("goods_effct", "effect,goods", GoodsEffct.class);
		arp.addMapping("goods_oper_flow", "id", GoodsOperFlow.class);
		// Composite Primary Key order: goods,promotions
		arp.addMapping("goods_promotion", "goods,promotions", GoodsPromotion.class);
		arp.addMapping("goods_review", "id", GoodsReview.class);
		arp.addMapping("goods_review_comment", "id", GoodsReviewComment.class);
		// Composite Primary Key order: goods,tags
		arp.addMapping("goods_tag", "goods,tags", GoodsTag.class);
		arp.addMapping("goods_theme", "id", GoodsTheme.class);
		arp.addMapping("group_buy", "id", GroupBuy.class);
		arp.addMapping("group_remind", "id", GroupRemind.class);
		arp.addMapping("groups", "id", Groups.class);
		arp.addMapping("groups_create", "id", GroupsCreate.class);
		arp.addMapping("groups_join", "id", GroupsJoin.class);
		arp.addMapping("houserkeeper", "id", Houserkeeper.class);
		arp.addMapping("houserkeeper_grade", "id", HouserkeeperGrade.class);
		arp.addMapping("information", "id", Information.class);
		arp.addMapping("interest_category", "id", InterestCategory.class);
		arp.addMapping("like_commend", "id", LikeCommend.class);
		arp.addMapping("log", "id", Log.class);
		arp.addMapping("member", "id", Member.class);
		arp.addMapping("member_attribute", "id", MemberAttribute.class);
		// Composite Primary Key order: favorite_goods,favorite_members
		arp.addMapping("member_favorite_goods", "favorite_goods,favorite_members", MemberFavoriteGoods.class);
		// Composite Primary Key order: interest_category,members
		arp.addMapping("member_interest_category", "interest_category,members", MemberInterestCategory.class);
		arp.addMapping("member_message", "id", MemberMessage.class);
		arp.addMapping("member_rank", "id", MemberRank.class);
		// Composite Primary Key order: members,skin_type
		arp.addMapping("member_skin_type", "members,skin_type", MemberSkinType.class);
		arp.addMapping("message", "id", Message.class);
		arp.addMapping("message_config", "id", MessageConfig.class);
		arp.addMapping("message_link", "id", MessageLink.class);
		arp.addMapping("miaobi_goods", "id", MiaobiGoods.class);
		arp.addMapping("miaobi_log", "id", MiaobiLog.class);
		arp.addMapping("miaobi_lssue", "id", MiaobiLssue.class);
		arp.addMapping("miaobi_lssuelog", "id", MiaobiLssuelog.class);
		arp.addMapping("mrmf_shop", "id", MrmfShop.class);
		arp.addMapping("navigation", "id", Navigation.class);
		arp.addMapping("newGoods_commend", "id", NewgoodsCommend.class);
		arp.addMapping("nodify_goods_send", "id", NodifyGoodsSend.class);
		arp.addMapping("order", "id", Order.class);
		arp.addMapping("order_cancel", "id", OrderCancel.class);
		arp.addMapping("order_item", "id", OrderItem.class);
		arp.addMapping("order_log", "id", OrderLog.class);
		arp.addMapping("organ", "id", Organ.class);
		arp.addMapping("parameter", "id", Parameter.class);
		arp.addMapping("partner", "id", Partner.class);
		arp.addMapping("payment", "id", Payment.class);
		arp.addMapping("payment_log", "id", PaymentLog.class);
		arp.addMapping("payment_method", "id", PaymentMethod.class);
		arp.addMapping("permission", "id", Permission.class);
		// Composite Primary Key order: permissions,roles
		arp.addMapping("permission_role", "permissions,roles", PermissionRole.class);
		arp.addMapping("plugin_config", "id", PluginConfig.class);
		arp.addMapping("point_log", "id", PointLog.class);
		arp.addMapping("prestore", "id", Prestore.class);
		arp.addMapping("product", "id", Product.class);
		arp.addMapping("product_category", "id", ProductCategory.class);
		// Composite Primary Key order: brands,product_categories
		arp.addMapping("product_category_brand", "brands,product_categories", ProductCategoryBrand.class);
		// Composite Primary Key order: product_categories,promotions
		arp.addMapping("product_category_promotion", "product_categories,promotions", ProductCategoryPromotion.class);
		arp.addMapping("product_notify", "id", ProductNotify.class);
		arp.addMapping("promotion", "id", Promotion.class);
		// Composite Primary Key order: coupons,promotions
		arp.addMapping("promotion_coupon", "coupons,promotions", PromotionCoupon.class);
		// Composite Primary Key order: gift_promotions,gifts
		arp.addMapping("promotion_gift", "gift_promotions,gifts", PromotionGift.class);
		// Composite Primary Key order: member_ranks,promotions
		arp.addMapping("promotion_member_rank", "member_ranks,promotions", PromotionMemberRank.class);
		arp.addMapping("raffle", "id", Raffle.class);
		arp.addMapping("integral_log", "id", IntegralLog.class);
		arp.addMapping("integral_store", "id", IntegralStore.class);
		arp.addMapping("integral_store_log", "id", IntegralStoreLog.class);
		arp.addMapping("receiver", "id", Receiver.class);
		arp.addMapping("referrer_config", "id", ReferrerConfig.class);
		arp.addMapping("referrer_goods", "id", ReferrerGoods.class);
		arp.addMapping("refunds", "id", Refunds.class);
		arp.addMapping("returns", "id", Returns.class);
		arp.addMapping("returns_item", "id", ReturnsItem.class);
		arp.addMapping("returns_item_progress", "id", ReturnsItemProgress.class);
		arp.addMapping("reverse_auction", "id", ReverseAuction.class);
		arp.addMapping("reverse_auction_detail", "id", ReverseAuctionDetail.class);
		arp.addMapping("reverse_auction_histroy", "id", ReverseAuctionHistroy.class);
		arp.addMapping("reverse_auction_order", "id", ReverseAuctionOrder.class);
		arp.addMapping("reverse_auction_reminds", "id", ReverseAuctionReminds.class);
		arp.addMapping("review", "id", Review.class);
		arp.addMapping("role", "id", Role.class);
		arp.addMapping("seo", "id", Seo.class);
		arp.addMapping("share", "id", Share.class);
		arp.addMapping("shipping", "id", Shipping.class);
		arp.addMapping("shipping_item", "id", ShippingItem.class);
		arp.addMapping("shipping_method", "id", ShippingMethod.class);
		// Composite Primary Key order: payment_methods,shipping_methods
		arp.addMapping("shipping_payment_method", "payment_methods,shipping_methods", ShippingPaymentMethod.class);
		arp.addMapping("skin_type", "id", SkinType.class);
		arp.addMapping("sms", "id", Sms.class);
		arp.addMapping("sn", "id", Sn.class);
		arp.addMapping("specification", "id", Specification.class);
		arp.addMapping("staff_member", "id", StaffMember.class);
		arp.addMapping("staff_organ", "id", StaffOrgan.class);
		arp.addMapping("statistic", "id", Statistic.class);
		arp.addMapping("stock_log", "id", StockLog.class);
		arp.addMapping("tag", "id", Tag.class);
		arp.addMapping("target_path", "id", TargetPath.class);
		arp.addMapping("team_management", "id", TeamManagement.class);
		arp.addMapping("theme_product", "id", ThemeProduct.class);
		arp.addMapping("ticket", "id", Ticket.class);
		arp.addMapping("ticketconfig", "id", Ticketconfig.class);
		arp.addMapping("ticketreceive", "id", Ticketreceive.class);
		arp.addMapping("ticketsn", "id", Ticketsn.class);
		arp.addMapping("ticketsnrecord", "id", Ticketsnrecord.class);
		arp.addMapping("version", "id", Version.class);
		arp.addMapping("vipGoods_history", "id", VipgoodsHistory.class);
		arp.addMapping("special_personnel", "id", SpecialPersonnel.class);
	}
}

