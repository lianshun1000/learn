package com.learn.license;

import de.schlichtherle.license.*;


import javax.security.auth.x500.X500Principal;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.prefs.Preferences;

/**
 * @author lianshun
 * @date 2021/6/28 5:15 下午
 * @description
 */
public class CreateLicense {
    /**
     * X500Princal 是一个证书文件的固有格式，详见API
     */
    private final static X500Principal DEFAULT_HOLDERAND_ISSUER = new X500Principal("CN=Duke, OU=JavaSoft, O=Sun Microsystems, C=US");

    private String priAlias;
    private String privateKeyPwd;
    private String keyStorePwd;
    private String subject;
    private String priPath;

    private String issued;
    private String notBefore;
    private String notAfter;
    private String ipAddress;
    private String macAddress;
    private String consumerType;
    private int consumerAmount;
    private String info;

    private String licPath;


    /**
     * 构造器，参数初始化
     *
     * @param confPath 参数配置文件路径
     */
    public CreateLicense(String confPath) {
        // 获取参数
        Properties prop = new Properties();
        try (InputStream in = getClass().getResourceAsStream(confPath)) {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //common param
        priAlias = prop.getProperty("private.key.alias");
        privateKeyPwd = prop.getProperty("private.key.pwd");
        keyStorePwd = prop.getProperty("key.store.pwd");
        subject = prop.getProperty("subject");
        priPath = prop.getProperty("priPath");
        // license content
        issued = prop.getProperty("issuedTime");
        notBefore = prop.getProperty("notBefore");
        notAfter = prop.getProperty("notAfter");
        /*ipAddress = prop.getProperty("ipAddress");
        macAddress = prop.getProperty("macAddress");*/
        consumerType = prop.getProperty("consumerType");
        consumerAmount = Integer.valueOf(prop.getProperty("consumerAmount"));
        info = prop.getProperty("info");

        licPath = prop.getProperty("licPath");
    }


    /**
     * 生成证书，在证书发布者端执行
     *
     * @throws Exception
     */
    public void create() throws Exception {
        LicenseManager licenseManager = LicenseManagerHolder.getLicenseManager(initLicenseParams());
        licenseManager.store(buildLicenseContent(), new File(licPath));
        System.out.println("------ 证书发布成功 ------");
    }

    /**
     * 初始化证书的相关参数
     *
     * @return
     */
    private LicenseParam initLicenseParams() {
        Class<CreateLicense> clazz = CreateLicense.class;
        Preferences preferences = Preferences.userNodeForPackage(clazz);
        // 设置对证书内容加密的对称密码
        CipherParam cipherParam = new DefaultCipherParam(keyStorePwd);
        // 参数 1,2 从哪个Class.getResource()获得密钥库;
        // 参数 3 密钥库的别名;
        // 参数 4 密钥库存储密码;
        // 参数 5 密钥库密码
        KeyStoreParam privateStoreParam = new DefaultKeyStoreParam(clazz, priPath, priAlias, keyStorePwd, privateKeyPwd);
        // 返回生成证书时需要的参数
        return new DefaultLicenseParam(subject, preferences, privateStoreParam, cipherParam);
    }

    /**
     * 通过外部配置文件构建证书的的相关信息
     *
     * @return
     * @throws ParseException
     */
    public LicenseContent buildLicenseContent() throws ParseException {
        LicenseContent content = new LicenseContent();
        SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
        content.setConsumerAmount(consumerAmount);
        content.setConsumerType(consumerType);
        content.setHolder(DEFAULT_HOLDERAND_ISSUER);
        content.setIssuer(DEFAULT_HOLDERAND_ISSUER);
        content.setIssued(formate.parse(issued));
        content.setNotBefore(formate.parse(notBefore));
        content.setNotAfter(formate.parse(notAfter));
        content.setInfo(info);
        // 扩展字段
        Map<String, String> map = new HashMap<>(4);
        /*map.put("ip", ipAddress);
        map.put("mac", macAddress);*/
        content.setExtra(map);
        return content;
    }
}
