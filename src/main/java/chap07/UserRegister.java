package chap07;

public class UserRegister {
    private WeakPasswordChecker passwordChecker;
    private UserRepository userRepository;

    public UserRegister(WeakPasswordChecker passwordChecker, UserRepository userRepository) {
        this.passwordChecker = passwordChecker;
        this.userRepository = userRepository;
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
    }
}
