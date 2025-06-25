
# Final project: Bếp An Toàn

Dự án **BepAnToanProject** là hệ thống kiểm thử tự động các chức năng chính của website [https://bepantoan.vn](https://bepantoan.vn/) bằng **Java + Selenium WebDriver + TestNG**, tích hợp **Allure Report** để theo dõi kết quả kiểm thử trực quan.
## 📌 Mục tiêu dự án

- Kiểm thử tự động các luồng chức năng quan trọng trên website như: đăng nhập, tìm kiếm, thêm vào giỏ hàng, thanh toán…
- Đảm bảo tính ổn định và độ tin cậy của website thông qua kiểm thử định kỳ.
- Cung cấp báo cáo trực quan bằng Allure để dễ dàng theo dõi kết quả test.

---
## ⚙️ Công nghệ sử dụng

| Thành phần        | Công nghệ                         |
|-------------------|-----------------------------------|
| Ngôn ngữ chính     | Java                              |
| Framework kiểm thử | TestNG                            |
| Trình điều khiển   | Selenium WebDriver                |
| Báo cáo            | Allure Report                     |
| Quản lý dependency | Maven                             |
| Hỗ trợ             | Tự động cập nhật WebDriver (WebDriverManager) |

---
## 🚀 Hướng dẫn chạy test

### 1. Cài đặt phụ thuộc

Đảm bảo bạn đã cài đặt:

- [Java 11+](https://adoptium.net/)
- [Maven](https://maven.apache.org/download.cgi)
- [Allure Commandline](https://docs.qameta.io/allure/#_installing_a_commandline)

Sau đó, chạy:


`mvn clean install`

### 2. Chạy test bằng TestNG

`mvn test`

hoặc

`mvn clean test -DsuiteXmlFile=testng.xml`

### 3. Sinh báo cáo bằng Allure

`allure serve allure-results`

hoặc

`allure generate allure-results --clean -o allure-report`

`allure open allure-report`