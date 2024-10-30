import java.awt.*;
import javax.swing.*;

/**
 * 중간고사 계산기 만들기
 */
public class MidTermCalc extends JFrame {
    /**
     * 계산기
     */
    MidTermCalc() {
        setTitle("계산기");

        setLayout(new BorderLayout());
        showCenter(); showSouth();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setVisible(true);
    }

    /**
     * 계산결과 표시
     */
    void showCenter() {
        JPanel panel = new JPanel();

        //숫자창
        JTextField text = new JTextField(10);
        panel.add(text);

        add(panel, BorderLayout.CENTER);
    }
    void showSouth() {

    }
    public static void main(String[] args) {
        new MidTermCalc();
    }
}
