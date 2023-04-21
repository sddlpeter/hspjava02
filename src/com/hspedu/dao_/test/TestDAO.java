package com.hspedu.dao_.test;

import com.hspedu.dao_.dao.ActorDAO;
import com.hspedu.dao_.dao.GoodsDAO;
import com.hspedu.dao_.dao.OrderDAO;
import com.hspedu.dao_.domain.Actor;
import com.hspedu.dao_.domain.Goods;
import com.hspedu.dao_.domain.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDAO {
    public static void main(String[] args) {

    }

    @Test
    public void testActorDAO() {
        ActorDAO actorDAO = new ActorDAO();
        System.out.println("查询多行结果：");
        List<Actor> actors = actorDAO.queryMulti("select * from actor where id >= ?", Actor.class, 1);
        for (Actor actor : actors) {
            System.out.println(actor);
        }
        System.out.println();


        System.out.println("查询单行结果：");
        Actor actor = actorDAO.querySingle("select * from actor where id = ?", Actor.class, 1);
        System.out.println(actor);
        System.out.println();

        System.out.println("查询单行单列：");
        Object o = actorDAO.queryScalar("select name from actor where id = ?", 2);
        System.out.println(o);
        System.out.println();

        System.out.println("修改操作：");
        int affectedRows = actorDAO.update("insert into actor values(null, ?, ?, ?, ?)", "HSP", "M", "1984-01-01", "550");
        System.out.println("修改行数 :" + affectedRows);
    }

    @Test
    public void testGoodsDAO() {
        GoodsDAO goodsDAO = new GoodsDAO();
        List<Goods> goods = goodsDAO.queryMulti("select * from Goods where price >= ?", Goods.class, 2000);
        for (Goods g : goods) {
            System.out.println(g);
        }
    }

    @Test
    public void testOrderDAO() {
        OrderDAO orderDAO = new OrderDAO();
        List<Order> orders = orderDAO.queryMulti("select * from orders where total >= ?", Order.class, 50);
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}
