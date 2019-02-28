package com.springboot.miaosha.dao;

import com.springboot.miaosha.domain.MiaoshaOrder;
import com.springboot.miaosha.domain.OrderInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: lei
 * @Description:
 * @Date: Created in 2019-02-28 15:53
 */

@Mapper
public interface OrderDao {

    @Select("select * from miaosha_order where user_id = #{userId} and goods_Id = #{goodsId}")
    public MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(long userId, long goodsId);

    @Insert("insert into order_info(user_id,goods_id,delivery_addr_id,goods_name,goods_count," +
            "goods_price,order_channel,status,create_date) values(" +
            "#{userId},#{goodsId},#{deliveryAddrId},#{goodsName},#{goodsCount},#{goodsPrice}," +
            "#{orderChannel},#{status},#{createDate})")
//    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = long.class, before
//            = false, statement = "select last_insert_id()")
    public long insert(OrderInfo orderInfo);

    @Insert("insert into miaosha_order(user_id,goods_id,order_id)values(#{userId},#{goodsId}" +
            ",#{orderId})")
    public int insertMiaoshaOrder(MiaoshaOrder miaoshaOrder);
}
