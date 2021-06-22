import model.*;
import model.Number;
import model.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;
import java.lang.String;


public class WindowSapper {
    int size;
    int bombs;
    Cell[][] cellesField;
    JButton[][] buttons;
    JLabel label;
    Dimension dimension = new Dimension(26, 26);
    ImageIcon buttonII = new ImageIcon("C:\\Yaroslava\\java.pictures\\button.gif");
    Image buttonImage = buttonII.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
    ImageIcon buttonIcone = new ImageIcon(buttonImage);

    ImageIcon oneII = new ImageIcon("C:\\Yaroslava\\java.pictures\\one.gif");
    Image oneImage = oneII.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
    ImageIcon oneIcone = new ImageIcon(oneImage);

    ImageIcon twoII = new ImageIcon("C:\\Yaroslava\\java.pictures\\two.gif");
    Image twoImage = twoII.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
    ImageIcon twoIcone = new ImageIcon(twoImage);

    ImageIcon threeII = new ImageIcon("C:\\Yaroslava\\java.pictures\\three.gif");
    Image threeImage = threeII.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
    ImageIcon threeIcone = new ImageIcon(threeImage);

    ImageIcon fourII = new ImageIcon("C:\\Yaroslava\\java.pictures\\four.gif");
    Image fourImage = fourII.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
    ImageIcon fourIcone = new ImageIcon(fourImage);

    ImageIcon fiveII = new ImageIcon("C:\\Yaroslava\\java.pictures\\five.gif");
    Image fiveImage = fiveII.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
    ImageIcon fiveIcone = new ImageIcon(fiveImage);

    ImageIcon sixII = new ImageIcon("C:\\Yaroslava\\java.pictures\\six.gif");
    Image sixImage = sixII.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
    ImageIcon sixIcone = new ImageIcon(sixImage);

    ImageIcon sevenII = new ImageIcon("C:\\Yaroslava\\java.pictures\\seven.gif");
    Image sevenImage = sevenII.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
    ImageIcon sevenIcone = new ImageIcon(sevenImage);

    ImageIcon eightII = new ImageIcon("C:\\Yaroslava\\java.pictures\\eight.gif");
    Image eightImage = eightII.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
    ImageIcon eightIcone = new ImageIcon(eightImage);

    ImageIcon flagII = new ImageIcon("C:\\Yaroslava\\java.pictures\\flag.gif");
    Image flagImage = flagII.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
    ImageIcon flagIcone = new ImageIcon(flagImage);

    ImageIcon openBombII = new ImageIcon("C:\\Yaroslava\\java.pictures\\openBomb.gif");
    Image openBombImage = openBombII.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
    ImageIcon openBombIcone = new ImageIcon(openBombImage);

    ImageIcon winII = new ImageIcon("C:\\Yaroslava\\java.pictures\\win.gif");
    Image winImage = winII.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
    ImageIcon winIcone = new ImageIcon(winImage);

    WindowSapper(int size, int bombs) {

        this.size = size;
        this.bombs = bombs;

        cellesField = new Cell[size][size];

        for (int i = 0; i < bombs; i++) {
            int x = (int) (Math.random() * size);
            int y = (int) (Math.random() * size);
            if (cellesField[x][y] instanceof Bomb) {
                i--;
            }
            cellesField[x][y] = new Bomb();
        }


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!(cellesField[j][i] instanceof Bomb)) {
                    int value = 0;
                    if (i != 0) {
                        if (cellesField[j][i - 1] instanceof Bomb) {
                            value++;
                        }
                    }
                    if (j != 0 & i != 0) {
                        if (cellesField[j - 1][i - 1] instanceof Bomb) {
                            value++;
                        }
                    }
                    if (j != 0) {
                        if (cellesField[j - 1][i] instanceof Bomb) {
                            value++;
                        }
                    }
                    if (j != 0 & i != size - 1) {
                        if (cellesField[j - 1][i + 1] instanceof Bomb) {
                            value++;
                        }
                    }
                    if (i != 0 & j != size - 1) {
                        if (cellesField[j + 1][i - 1] instanceof Bomb) {
                            value++;
                        }
                    }
                    if (i != size - 1 & j != size - 1) {
                        if (cellesField[j + 1][i + 1] instanceof Bomb) {
                            value++;
                        }
                    }
                    if (i != size - 1) {
                        if (cellesField[j][i + 1] instanceof Bomb) {
                            value++;
                        }
                    }
                    if (j != size - 1) {
                        if (cellesField[j + 1][i] instanceof Bomb) {
                            value++;

                        }
                    }
                    if (value != 0) {
                        cellesField[j][i] = new Number(value);
                    }
                }
            }

        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cellesField[j][i] == null) {
                    cellesField[j][i] = new EmptyCell();
                }
            }
        }


        JFrame frame = new JFrame("Sapper");
        JPanel field = new JPanel();
        GridLayout gl = new GridLayout(size, size);
        field.setLayout(gl);
        label = new JLabel(bombs + " бомб; поле" + size + "*" + size);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(field);
        panel.add(label);
        buttons = new JButton[size][size];
        for (Integer o = 0; o < size; o++) {
            for (Integer a = 0; a < size; a++) {
                buttons[a][o] = new JButton();
                buttons[a][o].setSize(dimension);
                buttons[a][o].setMaximumSize(dimension);
                buttons[a][o].setMinimumSize(dimension);
                buttons[a][o].setPreferredSize(dimension);
                buttons[a][o].setIcon(buttonIcone);
                field.add(buttons[a][o]);
                final Point point = new Point(a, o);
                buttons[a][o].addMouseListener(new MouseListener() {


                    public void mouseClicked(MouseEvent e) {

                    }

                    public void mousePressed(MouseEvent e) {

                    }

                    public void mouseReleased(MouseEvent e) {
                        if (!(cellesField[point.getX()][point.getY()].isOpened())) {


                            if (SwingUtilities.isLeftMouseButton(e)) {
                                if (!(cellesField[point.getX()][point.getY()].isTagged())) {
                                    openSpace(point);
                                }
                            } else {
                                cellesField[point.getX()][point.getY()].changeIsTagged();
                            }
                            paintFieled();
                        }
                    }

                    public void mouseEntered(MouseEvent e) {

                    }

                    public void mouseExited(MouseEvent e) {

                    }
                });
            }
        }


        JMenuBar menuBar = new JMenuBar();
        JMenu game = new JMenu("Game");
        JMenuItem end = new JMenuItem("End game");
        end.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        game.add(end);
        menuBar.add(game);
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);


    }


    private void openSpace(Point point) {
        final int x = point.getX();
        final int y = point.getY();
        if (cellesField[x][y].isOpened()) {
            return;
        }
        cellesField[x][y].setOpened();
        if (cellesField[x][y] instanceof EmptyCell) {
            if (x >= 1) {
                openSpace(new Point(x - 1, y));
            }
            if (y >= 1) {
                openSpace(new Point(x, y - 1));
            }
            if (y >= 1 & x >= 1) {
                openSpace(new Point(x - 1, y - 1));
            }

            if (x >= 1 & y < size - 1) {
                openSpace(new Point(x - 1, y + 1));
            }
            if (y >= 1 & x < size - 1) {
                openSpace(new Point(x + 1, y - 1));
            }
            if (x < size - 1) {
                openSpace(new Point(x + 1, y));
            }
            if (x < size - 1 & y < size - 1) {
                openSpace(new Point(x + 1, y + 1));
            }
            if (y < size - 1) {
                openSpace(new Point(x, y + 1));
            }
            buttons[point.getX()][point.getY()].setBackground(Color.LIGHT_GRAY);
        } else if (cellesField[x][y] instanceof Bomb) {
            for (int p = 0; p < size; p++) {
                for (int n = 0; n < size; n++) {
                    cellesField[n][p].setOpened();
                }
            }
        }


    }


    private void paintFieled() {
        if (checkVictory()) {
            label.setText("Вы выиграли");
            for (int p = 0; p < size; p++) {
                for (int n = 0; n < size; n++) {
                    if (!(cellesField[n][p].isOpened())) {
                        buttons[n][p].setIcon(winIcone);
                    } else {
                        buttons[n][p].setIcon(null);
                        buttons[n][p].setBackground(Color.LIGHT_GRAY);
                    }
                }
            }
        } else if (checkFall()) {
            label.setText("Вы проиграли");
            for (int p = 0; p < size; p++) {
                for (int n = 0; n < size; n++) {
                    if (cellesField[n][p] instanceof Bomb) {
                        buttons[n][p].setIcon(openBombIcone);
                    }
                }
            }
        } else {
            for (int p = 0; p < size; p++) {
                for (int n = 0; n < size; n++) {
                    if (cellesField[n][p].isOpened()) {
                        if (cellesField[n][p] instanceof EmptyCell) {
                            buttons[n][p].setBackground(Color.LIGHT_GRAY);
                            buttons[n][p].setIcon(null);
                        } else {
                            int value = ((Number) cellesField[n][p]).getValue();
                            if (value == 1) {
                                buttons[n][p].setIcon(oneIcone);
                            } else if (value == 2) {
                                buttons[n][p].setIcon(twoIcone);
                            } else if (value == 3) {
                                buttons[n][p].setIcon(threeIcone);
                            } else if (value == 4) {
                                buttons[n][p].setIcon(fourIcone);
                            } else if (value == 5) {
                                buttons[n][p].setIcon(fiveIcone);
                            } else if (value == 6) {
                                buttons[n][p].setIcon(sixIcone);
                            } else if (value == 7) {
                                buttons[n][p].setIcon(sevenIcone);
                            } else if (value == 8) {
                                buttons[n][p].setIcon(eightIcone);
                            }

                        }

                    } else {
                        if (cellesField[n][p].isTagged()) {
                            buttons[n][p].setIcon(flagIcone);
                        } else {
                            buttons[n][p].setIcon(buttonIcone);
                        }
                    }
                }
            }
        }
    }


    private boolean checkVictory() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!(cellesField[j][i].isOpened())) {
                    if (!(cellesField[j][i] instanceof Bomb)) {
                        return false;
                    }
                } else {
                    if (cellesField[j][i] instanceof Bomb) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    private boolean checkFall() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!(cellesField[j][i].isOpened())) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер поля");
        int size = 0;
        int bombs = 0;
        while (size == 0) {
            if (scanner.hasNextInt()) {
                int possibleSize = scanner.nextInt();
                if (possibleSize > 4 & possibleSize < 51) {
                    size = possibleSize;
                    int sizeSquared = size * size;
                    sizeSquared = sizeSquared / 6;
                    System.out.println("Введите количество бомб");
                    while (bombs == 0) {
                        if (scanner.hasNextInt()) {
                            int possibleBombs = scanner.nextInt();

                            if (possibleBombs >= size & possibleBombs < sizeSquared + 1) {
                                bombs = possibleBombs;
                                WindowSapper windowSapper = new WindowSapper(size, bombs);
                            } else {
                                System.out.println("Количество бомб должно быть в диапазоне от " + size + " до " + sizeSquared);
                                System.out.println("Введите количество бомб");
                            }
                        } else {
                            System.out.println("Введите число");
                            scanner.next();
                        }
                    }

                } else {
                    System.out.println("Размер поля должен быть в диапазоне от 5 до 50");
                    System.out.println("Введите размер поля");
                }
            } else {
                System.out.println("Введите число");
                scanner.next();
            }

        }
    }

}

