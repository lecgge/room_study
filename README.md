# room_study
## 学习ROOM的使用，其中包括增删改查、与livedata结合使用，数据库升级等。
room 数据库有三个比较重要的部分:

@Database：定义一个数据库, 同时必须使用entities属性定义包含哪些表；使用version属性表示数据库的版本号，用于数据库升级使用；同时对于Dao的实例化也是定义在@Database所注解的class内
@Dao：定义操作数据库表的各种api（比如：对表的增删改查）
@Entity（实体类）：定义一个table，实体类的每个属性 表示table的每个字段, 除非你用@Ignore 注解


### room使用步骤
1、导入依赖
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id 'org.jetbrains.kotlin.android.extensions'
    id 'org.jetbrains.kotlin.kapt'
}

    implementation "androidx.room:room-runtime:2.1.0"
    kapt "androidx.room:room-compiler:2.1.0"
    
2、创建entity类
通过注解@entity来声明entity类 room数据库将此类映射为同名的表
@Entity(tableName = "tab_user")//可以自定义表名
    @ColumnInfo(name = "uid") // 定义列的名字
    @PrimaryKey(autoGenerate = true) // 标示主键，并自增长
    @ColumnInfo // 如果没有指定列的名字，则使用字段名称
    @ColumnInfo 是非必须的，room 默认会将所有class的所有字段定义table的列
    
  如果需要使用多个字段一起当作主键，则需要使用@Entity注解中的primaryKeys属性定义联合主键
  
  忽略某个字段可以使用@Ignore注解
  
  使用@Entity注解中的foreignKeys属性可以定义两个表之间的外键关联
  
  使用@Entity注解中的indices属性添加索引
3、创建dao接口 dao接口是向外提供访问数据库的接口
    定义一个接口或抽象类，并使用@Dao注解这个类
    定义各种操作表的抽象方法，并使用@Query等注解对应的抽象方法
    @insert @update @delete @query
4、创建database抽象类
    定义一个抽象类继承RoomDatabase
    使用@Database注解这个抽象类，同时使用entities属性配置表，version配置版本号
    定义一系列的Dao层的抽象方法 向外提供dao对象
    
    在database类中创建单例的database对象，并向外暴露
    
 5、使用database对象，调用dao层的方法来操作数据库。
