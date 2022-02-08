package cn.prinf.demos.junit.powermock;

import java.time.Instant;

public class UserService {
    private UserRepository userRepository;
    private EmailService emailService;
    private EncryptionService encryptionService;

    public UserService(UserRepository userRepository, EmailService emailService, EncryptionService encryptionService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.encryptionService = encryptionService;
    }

    public void register(User user) {
        user.setPassword(encryptionService.sha256(user.getPassword()));
        user.setCreateAt(Instant.now());

        userRepository.saveUser(user);

        sendEmail(user);

        (new LogService()).log("finished register action");
    }

    private void sendEmail(User user) {
        String emailSubject = "Register Notification";
        String emailContent = "Register Account successful! your username is " + user.getUsername();
        emailService.sendEmail(user.getEmail(), emailSubject, emailContent);
    }
}
