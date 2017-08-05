package DataStruct.Test;

/**
 * Created by pokedo on 2017/4/10.
 */
//ÓÃÓÚÊµÏÖÒ»¸öË«ÏòÁ´±íµÄÔÚÍ·²¿µÄ²åÈë£¬ÔÚÎ²²¿µÄÉ¾³ýºÍÈ¡ÖµµÄ²Ù×÷
class DoubleLinkList<T> {
    //·Ö±ðÓÃÓÚÖ¸ÏòÍ·½áµãºÍÁ´±íµÄÎ²²¿½Úµã
    private DoubleNode<T> head;
    private DoubleNode<T> last;
    //ÓÃÓÚ¼ÇÂ¼ÏÂÁ´±íÖÐµÄ½ÚµãµÄÊýÄ¿
    private int count = 0;

    class DoubleNode<E> {
        //ÓÃÓÚ´æ´¢Êý¾Ý
        E data;
        //ÓÃÓÚ´æ´¢ÉÏÒ»¸ö½ÚµãºÍÏÂÒ»¸ö½ÚµãµÄÖ¸Õë
        DoubleNode<E> previous;
        DoubleNode<E> next;
    }

    //ÊµÏÖÔÚÍ·½Úµã´¦µÄ½ÚµãµÄ²åÈë
    public void insert(T data) {
        DoubleNode<T> news = new DoubleNode<T>();
        news.data = data;
        DoubleNode<T> temp = head;
        //µ±Á´±íÖÐµÄ½ÚµãÎª¿ÕµÄÊ±ºò£¬½«ÆäÖ¸ÏòµÚÒ»¸ö½Úµã£¬Ö®ºó±ã²»ÔÙ¸ü¸Ä¸Ã´¦µÄ½Úµã£¬ÓÉ´Ë¿ÉÒÔµÃµ½lasrÖ¸ÏòÁ´±íµÄÄ©Î²½Úµã
        if (temp == null) {
            last = news;
        }
        head = news;
        if (temp != null) {
            news.next = temp;
            temp.previous = news;
        }
        count++;
    }

    //ÊµÏÖÔÚÎ²½Úµã´¦µÄ½ÚµãµÄÉ¾³ý£¬²¢¶ÔÉ¾³ýµÄ½ÚµãµÄÊý¾Ý½øÐÐ·µ»Ø
    public T delete() {
        DoubleNode<T> temps = null;
        //µ±´æÔÚÁ½¸ö¼°ÒÔÉÏµÄ½ÚµãµÄÊýÄ¿Ê±
        if (last.previous != null) {
            last = last.previous;
            temps = last.next;
            last.next = null;
            temps.previous = null;
        }
        //µ±Ö»´æÔÚÒ»¸ö½ÚµãÊ±
        else {
            temps = last;
            last = null;
            head = null;
        }
        count--;
        return temps.data;
    }

    //ÊµÏÖ»ñµÃÎ²½ÚµãµÄÊý¾Ý£¬µ«²»¶ÔÊý¾Ý½øÐÐÉ¾³ý
    public T getLast() {
        return last.data;
    }

    //ÓÃÓÚ»ñÈ¡Á´±íÖÐµÄ½ÚµãµÄÊýÄ¿
    public int getCount() {
        return this.count;
    }
}

