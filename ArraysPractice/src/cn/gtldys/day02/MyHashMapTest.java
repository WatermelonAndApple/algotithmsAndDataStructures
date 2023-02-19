package cn.gtldys.day02;


import java.util.Iterator;
import java.util.LinkedList;

/*
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * 实现 MyHashMap 类：
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 */
public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap tm = new MyHashMap();
        tm.put(1,1);
        tm.put(2,2);
        System.out.println(tm.get(1));
        System.out.println(tm.get(3));
        System.out.println(tm.get(2));
        tm.put(2,1);
        System.out.println(tm.get(2));
        tm.remove(2);
        System.out.println(tm.get(2));
    }
}
//使用链表实现的哈希表
class MyHashMap{

    private LinkedList<Pair> [] myHashMap;
    private static int BASE=729;
    //键值对
    private class Pair{
        private int key;//键
        private int value;//值
        Pair(){

        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public MyHashMap() {
        //初始化内存地址
       myHashMap=new LinkedList[BASE];
       for(int i=0;i<BASE;++i){
           myHashMap[i]=new LinkedList<Pair>();
       }
    }

    public void put(int key, int value) {
        int hash=calcHash(key);//计算哈希值
        LinkedList tmp=myHashMap[hash];
        //遍历该哈希表
        Iterator<Pair> i=tmp.iterator();
        while (i.hasNext()){
            Pair tmpPair=i.next();
            if(tmpPair.getKey()==key){//如果存在该键值对
                tmpPair.setValue(value);//更改该键值对的值
                return;
            }
        }
        //如果不存在该键值对，则键该键值对添加到改哈希表中
        Pair newPair=new Pair();;
        newPair.setKey(key);
        newPair.setValue(value);
        tmp.addLast(newPair);

    }
    //获取元素
    public int get(int key) {
        int hash=calcHash(key);//计算哈希值
        LinkedList tmp=myHashMap[hash];
        //遍历该哈希表
        Iterator<Pair> i=tmp.iterator();
        while (i.hasNext()){
            Pair tmpPair=i.next();
            if(tmpPair.getKey()==key){//如果存在该键值对
                return tmpPair.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash=calcHash(key);//计算哈希值
        LinkedList tmp=myHashMap[hash];//找到该key所在的链表位置
        //遍历该哈希表
        Iterator<Pair> i=tmp.iterator();
        Pair tmpPair=null;
        while (i.hasNext()){
            tmpPair=i.next();
            if(tmpPair.getKey()==key){//如果存在该键值对
                tmp.remove(tmpPair);
            }
        }
//        tmp.remove(tmpPair);//移除该键值对
    }
    private static int calcHash(int key){
        return key % BASE;//计算哈希值
    }

}
