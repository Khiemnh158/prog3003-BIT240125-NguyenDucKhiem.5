// 1. Tạo interface MessageService
interface MessageService {
    void sendMessage(String message);
}

// 2. Tạo lớp implement: EmailService
class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Đang gửi Email: " + message);
    }
}

// 2. Tạo lớp implement: SMSService
class SMSService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Đang gửi SMS: " + message);
    }
}

// 3. Tạo lớp Notification sử dụng Setter Injection
class Notification {
    private MessageService messageService;

    // Phương thức Setter để tiêm (inject) dependency
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notifyUser(String message) {
        if (messageService != null) {
            messageService.sendMessage(message);
        } else {
            System.out.println("Lỗi: Chưa cấu hình dịch vụ gửi tin nhắn!");
        }
    }
}

// 4. Chương trình demo
public class SetterInjectionDemo {
    public static void main(String[] args) {
        Notification notification = new Notification();

        // Sử dụng EmailService
        notification.setMessageService(new EmailService());
        notification.notifyUser("Chào mừng bạn đến với hệ thống!");

        // Chuyển đổi sang SMSService một cách linh hoạt qua Setter
        notification.setMessageService(new SMSService());
        notification.notifyUser("Mã OTP của bạn là 123456.");
    }
}