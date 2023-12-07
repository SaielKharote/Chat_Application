package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Server extends JFrame implements ActionListener {
    JTextField text;
    JPanel newPanel;
    Box vertical = Box.createVerticalBox();

    Server() {
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 70);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5, 20, 25, 25);
        p1.add(back);

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile1 = new JLabel(i6);
        profile1.setBounds(40, 10, 50, 50);
        p1.add(profile1);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i8 = i7.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel phone = new JLabel(i9);
        phone.setBounds(320, 20, 25, 25);
        p1.add(phone);

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i11 = i10.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel video = new JLabel(i12);
        video.setBounds(370, 20, 25, 25);
        p1.add(video);

        ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i17 = i16.getImage().getScaledInstance(12, 25, Image.SCALE_DEFAULT);
        ImageIcon i18 = new ImageIcon(i17);
        JLabel morevert = new JLabel(i18);
        morevert.setBounds(420, 20, 25, 25);
        p1.add(morevert);

        JLabel name = new JLabel("Mr. Modi");
        name.setBounds(110, 15, 100, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        p1.add(name);

        JLabel status = new JLabel("Online");
        status.setBounds(110, 40, 100, 13);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 13));
        p1.add(status);

        newPanel = new JPanel();
        newPanel.setBounds(5, 75, 440, 570);
        add(newPanel);

        text = new JTextField();
        text.setBounds(5, 655, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(text);

        JButton send = new JButton("Send");
        send.setBounds(320, 655, 123, 40);
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        add(send);


        setUndecorated(true);
        setSize(450, 700);
        setLocation(200, 50);
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Server();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String out = text.getText();

        JPanel p2 = formatLabel(out);
        newPanel.setLayout(new BorderLayout());
        JPanel right = new JPanel(new BorderLayout());
        right.add(p2, BorderLayout.LINE_END);
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(15));
        newPanel.add(vertical, BorderLayout.PAGE_START);

        text.setText("");
        repaint();
        revalidate();
        validate();
    }

    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS) );

        JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(37, 211, 102));
        output.setBorder(new EmptyBorder(12, 15, 12, 50));
        output.setOpaque(true);
        panel.add(output);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));

        panel.add(time);

        return panel;
    }
}
