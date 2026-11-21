# Robot 2027 — Phiên Bản V1.4 Pro

Dự án hoàn chỉnh đóng gói chuẩn **Capacitor Android + GitHub Actions** sẵn sàng import vào **Spck Editor** và tự động biên dịch file `.apk`.

## Cấu trúc thư mục
- `www/index.html`, `www/style.css`, `www/app.js`: Giao diện 6 tab (Header 52px), khuôn mặt biểu cảm, bảng Karaoke đánh vần từng từ, chu trình ngủ 2 giai đoạn (`10s` hỏi gợi ý + `10s` ngủ tiết kiệm pin), lắng nghe liên tục `Hello` / `Lucky` / `Hello Lucky`, điều khiển giọng nói `"Tôi muốn..."` (đèn đầu/tay, xoay đầu đa hướng nhiều lần, màn hình, âm lượng, học tập, thành viên gia đình), đồng bộ sao `api_point.php` mỗi `2s` và hướng dẫn sử dụng chi tiết.
- `native_src/com/robot2027/companion/RobotNativePlugin.java` & `MainActivity.java`: Plugin Android Native xử lý ghim Kiosk vĩnh viễn (`LockTask`), xin trọn bộ quyền (Camera, Ảnh, Mic, BLE, Wi-Fi/Vị trí), đọc Pin/Nhiệt độ/Wi-Fi, TTS hai ngôn ngữ và nhận diện giọng nói không tiếng bíp.
- `scripts/patch_android.py`: Script Python tự động tích hợp Java Native & quyền AndroidManifest khi GitHub Actions build APK.
- `.github/workflows/build-apk.yml` & `.gitignore`: Workflow tự động xuất file `Robot2027-V1.4-Pro-Debug.apk`.
- `spck_hidden_files/`: Bản sao hiển thị của `build-apk.yml` và `gitignore.txt` phòng trường hợp Spck Editor bỏ qua thư mục ẩn bắt đầu bằng dấu chấm (`.`) khi giải nén ZIP.

## Mã bảo mật mặc định (Có thể đổi trong Cài đặt)
- **Mã PIN Phụ huynh (mở tab Cài đặt `⚙️`, không thể thoát App):** `1234`
- **Mã Nhà phát triển (gỡ ghim Kiosk thoát về điện thoại):** `DEV2027PRO`
