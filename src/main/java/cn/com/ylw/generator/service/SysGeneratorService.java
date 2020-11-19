package cn.com.ylw.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author YangLinWei
 */
@Service
public interface SysGeneratorService extends IService {

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);

    byte[] generateZip(String[] tableNames);


}
