package com.example.ssm.fortest;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DesktopTime extends JFrame {
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss:sss");
    private boolean flag = true;

    public DesktopTime() {
        setVisible(true);
        setBounds(200, 200, 600, 500);
        setTitle("桌面时钟");
    }

    public void showTime() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        JButton button = new JButton("停止时钟");

        panel.add(label);
        panel.add(button);
        this.add(panel);

        button.addActionListener((actionEvent) -> {
            flag = false;
        });

        new Thread(() -> {
            while (flag) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                label.setText(simpleDateFormat.format(Calendar.getInstance().getTime()));
            }
        }).start();

    }

}
