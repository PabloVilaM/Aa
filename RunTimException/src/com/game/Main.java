    package com.game;

    import javax.swing.*;
    import java.awt.*;
    import java.util.Timer;
    import java.util.TimerTask;
    import javafx.animation.KeyFrame;
    import javafx.animation.Timeline;
    import javafx.application.Application;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.scene.Scene;
    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.input.KeyEvent;
    import javafx.scene.layout.*;
    import javafx.scene.layout.Pane;
    import javafx.scene.paint.Color;
    import javafx.scene.shape.Circle;
    import javafx.scene.shape.Rectangle;
    import javafx.scene.shape.Shape;
    import javafx.stage.Stage;
    import javafx.util.Duration;
    import javafx.geometry.Rectangle2D;


    public class Main extends Application{

        final int TAMX = 1100;
        final int TAMY = 618;
        final int STICK_ANCHO = 7;
        final int STICK_ALTURA = 50;
        int ballCenterX;
        int ballCurrentSpeedX = 3;
        int stickPosY = (STICK_ALTURA-STICK_ANCHO) /2;
        int stickCurrentSpeed = 0;
        int imagey = 100;
        int imagex = 100;
        int imgcurrentspeed = 0;
        float segundos = 0.017f;

        int misilx = 0;
        int misily = 0;
        float misilspeed = 0;

        int misilmalox = 0;
        int misilmaloy = 0;
        float misilmalospeed = 0;

        Timeline animationball;
        @Override
        public void start(Stage primaryStage){
            Pane root = new Pane();
            Scene scene = new Scene(root, TAMX, TAMY, Color.BLACK);
            primaryStage.setTitle("This is a game i dont know");
            primaryStage.setScene(scene);
            primaryStage.show();

            Circle circleball = new Circle(10,30,7, Color.WHITE);
            root.getChildren().add(circleball);

            Rectangle rect = new Rectangle(500,stickPosY, STICK_ANCHO, STICK_ALTURA);
            rect.setFill(Color.WHITE);
            root.getChildren().add(rect);


            Image image3 = new Image("file:Missile.png");
            ImageView mv3 = new ImageView(image3);
            root.getChildren().add(mv3);
            mv3.setRotate(90);
            mv3.setLayoutX(50);
            mv3.setLayoutY(325);
            mv3.setFitHeight(50);
            mv3.setFitWidth(50);
            mv3.setPreserveRatio(true);

            Image image5 = new Image("file:MissilVerde.png");
            ImageView mv5 = new ImageView(image5);
            root.getChildren().add(mv5);
            mv5.setLayoutX(1030);
            mv5.setLayoutY(330);
            mv5.setFitHeight(50);
            mv5.setFitWidth(50);
            mv5.setRotate(-90);
            mv5.setPreserveRatio(true);

            Shape.intersect(circleball, rect);
            Image image = new Image("file:spaceShipSingleShoot.png");
            ImageView mv = new ImageView(image);
            root.getChildren().add(mv);
            mv.setRotate(-90);
            mv.setLayoutX(-100);
            mv.setLayoutY(200);
            mv.setFitHeight(100);
            mv.setFitWidth(100);
            mv.setPreserveRatio(true);

            Image image4 = new Image("file:ovni.png");
            ImageView mv4 = new ImageView(image4);
            root.getChildren().add(mv4);
            mv4.setLayoutX(1000);
            mv4.setLayoutY(330);
            mv4.setFitHeight(100);
            mv4.setFitWidth(100);
            mv4.setPreserveRatio(true);


            BackgroundImage myBI= new BackgroundImage(new Image("file:cityskyline.png",1100,634,false,true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);
                //then you set to your node
            root.setBackground(new Background(myBI));
             animationball = new Timeline(
                    new KeyFrame(Duration.seconds(segundos), (ActionEvent ae)-> {
                        imagex += imgcurrentspeed;
                        mv.setY(imagey);
                        mv.setX(imagex);

                        misilx += misilspeed;
                        mv3.setY(misily);
                        mv3.setX(misilx);

                        misilmalox += misilmalospeed;
                        mv5.setY(misilmaloy);
                        mv5.setX(misilmalox);

                        stickPosY += stickCurrentSpeed;
                        rect.setY(stickPosY);

                        ballCenterX+= ballCurrentSpeedX;
                        circleball.setCenterX(ballCenterX);
                        if (ballCenterX >= TAMX){
                            ballCurrentSpeedX = -3;
                        }
                        else if(ballCenterX <= 0){
                            ballCurrentSpeedX = 3;
                        }

                        if (misilx >= 995){
                            misilspeed = 0.0001f;
                            misilmalospeed = 0.0001f;
                            animationball.pause();
                            mv5.setLayoutX(1030);
                            mv5.setLayoutY(330);
                            misilmalox = 0;
                            mv3.setLayoutX(50);
                            mv3.setLayoutY(325);
                            misilx = 0;
                            JOptionPane.showInputDialog("A");
                            int numero = (int)(Math.random()*100+0);
                            animationball.play();
                        }



                        if(stickPosY<0){
                            stickPosY = 0;
                        } else{
                            if(stickPosY > TAMY - STICK_ALTURA){
                                stickPosY = TAMY - STICK_ALTURA;
                            }
                        }


                        Shape colision = Shape.intersect(circleball, rect);

                        boolean colisionVacia = colision.getBoundsInLocal().isEmpty();

                        if (colisionVacia == false){
                            ballCurrentSpeedX = -3;
                        }

                    })
            );
            animationball.setCycleCount(Timeline.INDEFINITE);
            animationball.play();



            scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
                public void handle(KeyEvent event){
                    switch(event.getCode()){
                        case UP:
                            stickCurrentSpeed = -6;
                            break;
                        case DOWN:
                            stickCurrentSpeed = 6;
                            break;
                        case SPACE:
                            misilspeed = 8;
                            misilmalospeed = -8;
                            break;
                    }
                }
            });

            scene.setOnKeyReleased(new EventHandler<KeyEvent>(){
                public void handle(KeyEvent event){

                }
            });

        }
        public static void main(String[] args) {

            launch();
        }

        public void justMakeItStop(){
            animationball.stop();
        }
    }