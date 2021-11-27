package start.tdd.chap07;

public class UserRegister {
    private WeakPasswordChecker passwordChecker;
    private UserRepository userRepository;
    private EmailNotifier emailNotifier;

    public UserRegister(WeakPasswordChecker passwordChecker,
                        UserRepository userRepository,
                        EmailNotifier emailNotifier) {
        this.passwordChecker = passwordChecker;
        this.userRepository = userRepository;
        this.emailNotifier = emailNotifier;
    }

    /**
     * 회원 가입
     *
     * @param id
     * @param pw
     * @param email
     */
    public void register(String id, String pw, String email) {
        //비밀번호 검증
        if (passwordChecker.checkPasswordWeak(pw)) {
            throw new WeakPasswordException();
        }

        //ID 중복 검증
        User user = userRepository.findById(id);
        if (user != null) {
            throw new DupIdException();
        }

        //회원 등록
        userRepository.save(new User(id, pw, email));

        //회원 가입 알림 이메일 발송
        emailNotifier.sendRegisterEmail(email);
    }
}
