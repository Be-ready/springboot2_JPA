代码功能：
    在springboot整合JPA的基础上实现：
        1、单表的增删改查
        2、多表的增删改查（一对多，多对一）
    sql语句：
        insert into book (bookname) values("《活着》")
        insert into book (bookname) values("《SpringBoot详解》")
        insert into book (bookname) values("《Mybatis详解》")
        insert into book (bookname) values("《骆驼祥子》")
        insert into book (bookname) values("《狂人日记》")
        insert into book (bookname) values("《飞鸟集》")

        insert into author (authorname) values("鲁迅")
        insert into author (authorname) values("雷丰阳")
        insert into author (authorname) values("胡适")
        insert into author (authorname) values("海子")
        insert into author (authorname) values("吴承恩")
        insert into author (authorname) values("小黑")
        insert into author (authorname) values("余华")

        insert into book_author (book_id, author_id) values(1,7)
        insert into book_author (book_id, author_id) values(2,2)
        insert into book_author (book_id, author_id) values(3,2)
        insert into book_author (book_id, author_id) values(4,1)
        insert into book_author (book_id, author_id) values(5,1)
        insert into book_author (book_id, author_id) values(3,6)

        select b.id, b.bookname , GROUP_CONCAT(a.authorname SEPARATOR';') as authorName from book b, author a, book_author ba where b.id = ba.book_id and a.id=ba.author_id and b.bookname like '%详解%' group by b.id, b.bookname
        select b.id, b.bookname , a.authorname from book b, author a, book_author ba where b.id = ba.book_id and a.id=ba.author_id and b.bookname like '%详解%'


        select b.id, GROUP_CONCAT(b.bookname SEPARATOR';') as bookName, a.authorname from book b, author a, book_author ba where b.id = ba.book_id and a.id=ba.author_id and a.authorname='鲁迅' group by b.id, a.authorname
        select a.id, a.authorname, GROUP_CONCAT(b.bookname SEPARATOR ';') from book b, author a, book_author ba where b.id = ba.book_id and a.id=ba.author_id and a.authorname='鲁迅' group by a.id, a.authorname

注释：
    在多表查询时，要定义一个主键类（本例中为BookAuthor），主键类的属性是有外键关系的两个实体类的id（使用注解@Id），
    同时要为主键类配置一个ID类,要求：
                        1、要implements Serializable
                        2、无参构造函数


https://github.com/Be-ready/springboot.git
