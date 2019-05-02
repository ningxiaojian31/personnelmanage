package cn.zdxh.personnelmanage.mapper;

import cn.zdxh.personnelmanage.po.EmployeeInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EmployeeInfoMapperTest {

    @Autowired
    private EmployeeInfoMapper employeeInfoMapper;

    @Test
    public void testInsert(){
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setEmpName("Justin");
        employeeInfo.setEmpNation("汉族");
        employeeInfo.setEmpSex(1);
        employeeInfo.setEmpSchool("新华学院");
        employeeInfo.setEmpPic("http://///");
        employeeInfo.setEmpPosition("后台开发");
        employeeInfo.setEmpBirthday(new Date());
        employeeInfo.setEmpPhone("13189461916");
        employeeInfo.setEmpNumber("121212");
        employeeInfo.setEmpMarry(1);
        employeeInfo.setEmpEmail("664650322@qq.com");
        employeeInfo.setEmpDepart("研发部");
        employeeInfo.setEmpAddr("麻涌镇");
        employeeInfo.setEmpCard("440883199703061916");
        employeeInfoMapper.insert(employeeInfo);
    }

    @Test
    public void testSelect(){
        EmployeeInfo employeeInfo = employeeInfoMapper.selectById(1);
        log.info("employeeInfo = {}",employeeInfo);
    }

    @Test
    public void testSelct2(){
        List<EmployeeInfo> infos = employeeInfoMapper.findAllEmployeeInfosBySearch("justin");
        for (EmployeeInfo  employeeInfo :infos){
            log.info("EmployeeInfo = {}",employeeInfo);
        }
    }
}
