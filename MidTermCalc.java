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
        JPanel panel = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        //넘버패드
        p1.setLayout(new GridLayout(4,3));
        JButton num0 = new JButton("0");
        JButton num1 = new JButton("1");
        JButton num2 = new JButton("2");
        JButton num3 = new JButton("3");
        JButton num4 = new JButton("4");
        JButton num5 = new JButton("5");
        JButton num6 = new JButton("6");
        JButton num7 = new JButton("7");
        JButton num8 = new JButton("8");
        JButton num9 = new JButton("9");
        JButton signs = new JButton("+/-");
        JButton dot = new JButton(".");


        p1.add(num7); p1.add(num8); p1.add(num9);
        p1.add(num4); p1.add(num5); p1.add(num6);
        p1.add(num1); p1.add(num2); p1.add(num3);
        p1.add(signs); p1.add(num0); p1.add(dot);

        panel.add(p1);

        add(panel, BorderLayout.SOUTH);


    }
    public static void main(String[] args) {
        new MidTermCalc();
    }
}
