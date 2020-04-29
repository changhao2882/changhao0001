package com.atguigu.cache.service;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames="emp")  //抽取缓存的公共配置
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    //将方法的运行结果进行缓存
    /**cacheManager管理多个cache组件，对缓存的真正操作在cache组件中，每一个缓存组件有自己唯一一个名字
     * cacheNames/value:指定缓存的名字
     * key:缓存数据使用的key,不指定默认使用方法参数的值  1-方法的返回值
     * keyGenerator:key的生成器；可以自己指定 key/keyGenerator二选一
     * cacheManager：指定缓存管理器；或者cacheResolver（缓存解析器）二选一
     * condition：指定符合条件的情况下才缓存
     * unless:否定缓存；当unless指定的条件为true,方法的返回值就不会被缓存；可以获取到结果（#result）进行判断
     * sync：缓存是否使用异步模式
     * cacheNames ={"emp"},key = "#id",condition = "#id>0",unless = "#result == null"
     */
    /**
     * 原理:
     * 1、自动配置类; CacheAutoConfiguration
     * 2、缓存的配置类
     * org. springframework. boot. autoconfigure. cache . GenericCacheConfiguration
     * org. springframework . boot. autoconfigure . cache . ICacheCacheConfiguration
     * org. springframework . boot . autoconfigure. cache . EhCacheCacheConfiguration
     * org. springframework . boot. autoconfigure . cache . HazelcastCacheConfiguration
     * org. springframework. boot . autoconfigure. cache. InfinispanCacheConfiguration
     * org. springframework . boot . autoconfigure . cache . CouchbaseCacheConfiguration
     * org. springframework . boot. autoconfigure . cache. RedisCacheConfiguration
     * org. springframework . boot. autoconfigure. cache . CaffeineCacheConfiguration
     * org. springframework . boot . autoconfigure. cache . GuavaCacheConfiguration
     * org. springframework. boot . autoconfigure. cache. Simpl eCacheConfiguration [默认]
     * org. springframework. boot. autoconfigure. cache . NoOpCacheConfiguration
     * 3、哪个配置类默认生效: SimpleCacheConfiguration;
     * 4、给容器中注册了一个CacheManager: ConcurrentMap
     *
     * 运行流程:
     * @Cacheable:
     * 1、方法运行之前，先去查询Cache (缓存组件)，按照cacheNames指定的名字获取;
     *  (CacheManager先获取相应的缓存) ，第一次获取缓存如果没有Cache组件会自动创建。
     * 2、去Cache中查找缓存的内容，使用一个key,默认就是方法的参数;
     *  key是按照某种策略生成的;默认是使用keyGenerator生成的，默认使用Simpl eKeyGenerator生成key;
     *  SimpleKeyGenerator生成key的默认策略;
     *      如果没有参数; key=new SimpleKey();
     *      如果有一个参数: key=参数的值
     *      如果有多个参数: key=new SimpleKey(params);
     * 3、没有查到缓存就调用目标方法;
     * 4、将目标方法返回的结果，放进缓存中
     *
     * @Cacheable标注的方法执行之前先来检查缓存中有没有这个数据，默认按照参数的值作为key去查询缓存，
     * 如果没有就运行方法并将结果放入缓存;以后再来调用就可以直接使用缓存中的数据;
     *
     * 核心: 1)、使用CacheManager [ConcurrentMapCacheManager]按照名字得到Cache [ConcurrentMapCache]组件
     *      2)、kgy使用keyGenerator生 成的，默认是SimpleKeyGenerator
     */

    @Cacheable(cacheNames ={"emp"}/*,keyGenerator = "myKeyGenerator",condition = "#a0>1",unless = "#a0==2"*/)
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    /**
     * @CachePut:既调用方法，又更新缓存数据
     * 修改了数据库的某个数据，同时更新缓存
     * 运行实际：
     * 1、先调用目标方法
     * 2、将目标方法的结果缓存起来
     *
     * 测试步骤
     * 1、查询1号员工，查询的结果会放在缓存中
     *      key:1 value:lastName=张三
     * 2、以后查询还是之前的结果
     * 3、更新1号员工 http://localhost:8080/emp?id=1&lastName=zhangsan&gender=0
     *      将方法的返回值放进缓存了
     *      key:传入的employee对象  value：返回的employee对象
     * 4、查询1号员工，为什么时没更新前的？
     *      1号员工没有在缓存中更新   key = "#employee.id" == key = "#result.id"
     * @Cacheable的key是不能用#result的，他是在运行方法之前
     */
    @CachePut(value = "emp",key = "#employee.id")
    public Employee updateEmp(Employee employee){
        System.out.println("更新"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict:缓存清除
     * 可以通过key指定要清除的数据
     *
     * allEntries = true 删除全部缓存的数据
     * ,beforeInvocation =  缓存的清除是否在方法执行之前清除（默认方法执行之后,如果出现异常就不会清除）
     */
    @CacheEvict(value = "emp",/*key = "#id",*/beforeInvocation = true)
    public void deleteEmp(Integer id){
        System.out.println("delete"+id);
        //employeeMapper.deleteEmpById(id);
        int i = 10 / 0;
    }

    //定义复杂的缓存规则
    @Caching(
            cacheable = {
                    @Cacheable(value = "emp",key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp",key = "#result.id"),
                    @CachePut(value = "emp",key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName){
        return employeeMapper.getEmpByLastName(lastName);
    }


}
