package com.company.ex.ex;

public class LinkList {
     Data  data;
     LinkList next;

     public LinkList create(Data data){
         LinkList header = null;
         if((header = new LinkList()) == null){
             System.out.println("allocation failed!");
         }
         header.data = data;
         header.next = null;
         return header;
     }

     public LinkList insert(LinkList header,Data data){
         LinkList node,p;

         p = header;

         if((node = new LinkList())  == null){
             System.out.println("allocation failed!");
         }

         node.data = data;

         if(header == null){
             node.next = header;
             header = node;
         }else{
             while(p.next != null){
                 p = p.next;
             }
             p.next = node;
         }
         return header;
     }

     public void traverse(LinkList list){
         LinkList TMP = list;
         while(TMP != null){
             System.out.printf("%d->",TMP.data.data);
             TMP = TMP.next;
         }
         System.out.println();
     }

     public LinkList calculator(LinkList a,LinkList b){
          LinkList test = new LinkList();
          LinkList c = null;

          LinkList TMP1 = a,TMP2 = b;
          int flag = 0;

          while(TMP1 != null && TMP2 != null){
             Data data1 = new Data();

             int ta = TMP1.data.data;
             int tb = TMP2.data.data;

             if(ta + tb + flag >= 10){
                 data1.data = (ta + tb + flag) % 10;
                 flag = (ta + tb) / 10;
             }else{
                 data1.data = ta + tb + flag;
                 flag = 0;
             }
             c = test.insert(c,data1);
             TMP1 = TMP1.next;
             TMP2 = TMP2.next;
          }
          return c;
     }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        Data data = new Data();
        data.data = 2;
        LinkList list = linkList.create(data);

        Data data1 = new Data();
        data1.data = 5;
        linkList.insert(list,data1);

        Data data4 = new Data();
        data4.data = 7;
        linkList.insert(list,data4);

        Data data2 = new Data();
        data2.data = 5;
        LinkList list1 =  linkList.create(data2);

        Data data3 = new Data();
        data3.data = 6;
        linkList.insert(list1,data3);

        Data data6 = new Data();
        data6.data = 4;
        linkList.insert(list1,data6);

        linkList.traverse(list);
        linkList.traverse(list1);

        System.out.println("about calculator");
        LinkList c = linkList.calculator(list,list1);
        linkList.traverse(c);
    }
}
