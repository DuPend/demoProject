package com.xinghuo.config;


/**
 * @description: redis操作教程
 * @author:  dupeng
 * @date: 2019-11-20 20:35
 * @version: V1.0
 */
public class RedisOperationCourse {
    /**
     *
     * 1.在service中添加:
     *  @Autowired
     *  private RedisTemplate<String, Object> redisTemplate;
     *
     *  2.操作各种数据类型
     *
     *     1).普通值
     *     		添加：redisTemplate.boundValueOps("name").set("itcast");
     * 		    取值：String str = (String) redisTemplate.boundValueOps("name").get();
     *          删除：redisTemplate.delete("name");
     *
     *     2）.set类型（注意其中的"nameset"要见名知意）
     *      1>.添加
     *        	redisTemplate.boundSetOps("nameset").add("曹操");
     * 			redisTemplate.boundSetOps("nameset").add("刘备");
     * 			redisTemplate.boundSetOps("nameset").add("孙权");
     *
     *      2>.取值
     *        Set members = redisTemplate.boundSetOps("nameset").members();
     *        System.out.println(members);
     * 		  结果为：[曹操，刘备，孙权]
     *
     *      3>.删除某一个值
     *       redisTemplate.boundSetOps("nameset").remove("孙权");
     *
     *      4>.删除整个
     *        redisTemplate.delete("nameset");
     *
     *     3).List类型
     *
     *        1>.添加及查询
     *
     *          右压栈：后添加的对象排在后边：
     * 			  redisTemplate.boundListOps("namelist1").rightPush("刘备");
     * 			  redisTemplate.boundListOps("namelist1").rightPush("关羽");
     * 			  redisTemplate.boundListOps("namelist1").rightPush("张飞");
     *
     *  		查询右压栈集合
     * 			  List list = redisTemplate.boundListOps("namelist1").range(0, 10);
     *			  System.out.println(list);
     * 			 显示结果为：
     * 			    [刘备, 关羽, 张飞]
     *
     * 			左压栈：后添加的对象排在前边
     * 			  redisTemplate.boundListOps("namelist2").leftPush("刘备");
     * 			  redisTemplate.boundListOps("namelist2").leftPush("关羽");
     * 			  redisTemplate.boundListOps("namelist2").leftPush("张飞");
     *
     * 			查询左压栈集合
     * 		      List list = redisTemplate.boundListOps("namelist2").range(0, 10);
     * 			  System.out.println(list);
     * 			  运行结果：
     * 			    [张飞, 关羽, 刘备]
     *
     * 		   2>.查询集合某个元素
     * 			  String s = (String) redisTemplate.boundListOps("namelist1").index(1);
     *
     * 		   3>.移除集合某个元素
     * 			  redisTemplate.boundListOps("namelist1").remove(1, "关羽");
     *
     *     4).Hash类型操作
     *     		1>.存值：
     * 			    redisTemplate.boundHashOps("namehash").put("a", "唐僧");
     * 			    redisTemplate.boundHashOps("namehash").put("b", "悟空");
     * 			    redisTemplate.boundHashOps("namehash").put("c", "八戒");
     * 			    redisTemplate.boundHashOps("namehash").put("d", "沙僧");
     *
     * 		    2>.提取所有的KEY
     * 			    Set s = redisTemplate.boundHashOps("namehash").keys();
     * 			    System.out.println(s);
     * 			    运行结果：
     * 			      [a, b, c, d]
     *
     * 		    3>.提取所有的值
     * 			    List values = redisTemplate.boundHashOps("namehash").values();
     * 			    System.out.println(values);
     * 			    运行结果：
     * 			      [唐僧, 悟空, 八戒, 沙僧]
     *
     * 		    4>.根据KEY提取值
     * 			    Object object = redisTemplate.boundHashOps("namehash").get("b");
     * 			    System.out.println(object);
     * 			    运行结果：
     * 			        悟空
     *
     * 		    5>.根据KEY移除值
     * 			    redisTemplate.boundHashOps("namehash").delete("c");
     * 			    运行后再次查看集合内容：
     * 			        [唐僧, 悟空, 沙僧]
     *
     *     5).javaBean的操作
     *
     * 		service先引入redisTemplate
     * 		@Autowired
     * 		private RedisTemplate<Serializable, Serializable> redisTemplate;
     *
     * 		1>.增加：
     * 			ValueOperations<Serializable, Serializable> operations = redisUsersTemplate.opsForValue();
     * 			operations.set(users.getUsername(), users);
     *
     * 		2>.获取：
     * 			ValueOperations<Serializable, Serializable> operations = redisUsersTemplate.opsForValue();
     * 			Users users = (Users) operations.get(username);
     *
     * 		3>>删除：
     * 			ValueOperations<Serializable, Serializable> operations = redisUsersTemplate.opsForValue();
     * 			operations.getOperations().delete(userName);
     *
     */



}
