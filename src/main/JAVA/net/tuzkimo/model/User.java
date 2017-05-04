package net.tuzkimo.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 用户实体
 * Created by tuzkimo on 2017-03-16.
 */
public class User {

    /*
     * 编号
     */
    private int id;
    /*
     * 用户名
     */
    @Size(min = 1, max = 25, message = "名称必须在 {2} 到 {1} 位之间")
    @Pattern(regexp = "^[\\w\\u4e00-\\u9fa5]+$", message = "名称只能是中英文字符和数字")
    private String name;
    /*
     * 密码
     */
    @Size(min = 6, max = 20, message = "密码必须在 {2} 到 {1} 位之间")
    private String password;
    /*
     * 描述
     */
    @Pattern(regexp = "^[^<>&#]*$", message = "请勿输入 < > & # 等非法字符")
    private String description;
    /*
     * 图片
     */
    private String photo;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, String description) {
        this.name = name;
        this.password = password;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

}
