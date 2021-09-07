package solution;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.*;
public class RollDice extends Application{
    Canvas canvas = new Canvas(200,200);
    AnimationTimer timer;


    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane(canvas);
        timer = new AnimationTimer( ) {

            long startTime = 0;
            long frameCounter = 0;
            public void handle(long time) {
                long currentTime = System.currentTimeMillis();
                if(startTime == 0){
                    startTime = System.currentTimeMillis();
                }else if(currentTime<startTime+(3*1000)){
                    frameCounter++;
                    if(frameCounter>10){
                        drawCanvas();
                        frameCounter = 0;
                    }
                }
                else {
                    timer.stop();
                    startTime=0;
                }
            }
        };

        Button rollButton = new Button("Roll Dice");
        rollButton.setOnAction(evt -> {
            timer.start();
        });

        HBox bottomBox = new HBox(rollButton);
        bottomBox.setAlignment(Pos.BASELINE_CENTER);
        root.setBottom(bottomBox);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        drawCanvas();
        primaryStage.show();
    }

    public void diceAnimation (){
        AnimationTimer timer = new AnimationTimer( ) {
            long previousFrameTime;
            public void handle(long time) {
                if (time - previousFrameTime > 0.95e9/60) {
                    previousFrameTime = time;
                    drawCanvas();
                    System.out.println("test");
                }
            }
        };
        timer.start();
        long startTime = System.currentTimeMillis();
        long currentTime;
        do {
            currentTime = System.currentTimeMillis();
        } while (currentTime<(startTime+(5*1000)));
        timer.stop();

    }




    public void drawCanvas(){
        GraphicsContext gContext = canvas.getGraphicsContext2D();
        gContext.setFill(Color.BISQUE);
        gContext.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

        rollDice(gContext);
    }

    public void drawDice (GraphicsContext graphicsContext, int dieValue, int xCoord, int yCoord){
        graphicsContext.setFill(Color.IVORY);
        graphicsContext.fillRect(xCoord,yCoord,60,60);
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.strokeRect(xCoord, yCoord, 60,60);
        graphicsContext.setFill(Color.BLACK);

        int dieEdgeX1 = xCoord;
        int dieEdgeY1 = yCoord;
        int dieEdgeX2 = xCoord+60;
        int dieEdgeY2= yCoord+60;

        int middleDotSide = dieEdgeX1+25;
        int leftDotSide = dieEdgeX1+10;
        int rightDotSide = dieEdgeX2-20;
        int topDotTop = dieEdgeY1+10;
        int middleDotTop = dieEdgeY1+25;
        int bottomDotTop = dieEdgeY2-20;

        switch (dieValue){
            case 1:
                graphicsContext.fillOval(middleDotSide,middleDotTop,10,10);
                break;
            case 2:
                graphicsContext.fillOval(leftDotSide,middleDotTop, 10,10);
                graphicsContext.fillOval(rightDotSide,middleDotTop, 10,10);
                break;
            case 3:
                graphicsContext.fillOval(middleDotSide,middleDotTop,10,10);
                graphicsContext.fillOval(leftDotSide,bottomDotTop, 10,10);
                graphicsContext.fillOval(rightDotSide,topDotTop, 10,10);
                break;
            case 4:
                graphicsContext.fillOval(leftDotSide,topDotTop, 10,10);
                graphicsContext.fillOval(leftDotSide,bottomDotTop, 10,10);
                graphicsContext.fillOval(rightDotSide,topDotTop, 10,10);
                graphicsContext.fillOval(rightDotSide,bottomDotTop, 10,10);
                break;
            case 5:
                graphicsContext.fillOval(middleDotSide,middleDotTop, 10,10);
                graphicsContext.fillOval(leftDotSide,topDotTop, 10,10);
                graphicsContext.fillOval(leftDotSide,bottomDotTop, 10,10);
                graphicsContext.fillOval(rightDotSide,topDotTop, 10,10);
                graphicsContext.fillOval(rightDotSide,bottomDotTop, 10,10);
                break;
            case 6:
                graphicsContext.fillOval(leftDotSide,topDotTop, 10,10);
                graphicsContext.fillOval(leftDotSide,bottomDotTop, 10,10);
                graphicsContext.fillOval(rightDotSide,topDotTop, 10,10);
                graphicsContext.fillOval(rightDotSide,bottomDotTop, 10,10);
                graphicsContext.fillOval(leftDotSide,middleDotTop, 10,10);
                graphicsContext.fillOval(rightDotSide,middleDotTop, 10,10);
        }
    }

    public void rollDice(GraphicsContext graphicsContext){
        boolean dieInQ1 = false;
        boolean dieInQ2 = false;
        boolean dieInQ3 = false;
        boolean dieInQ4 = false;
        int rolledDieNum = 0;
        while (rolledDieNum<2){
            int dieLocation = (int)(Math.random()*4);
            switch (dieLocation){
                case 0:
                    if(!dieInQ1){
                        dieInQ1=true;
                        rolledDieNum ++;
                        int dieRoll = (int)(Math.random()*6)+1;
                        drawDice(graphicsContext,dieRoll,20,20);
                    }
                    break;
                case 1:
                    if(!dieInQ2){
                        dieInQ2=true;
                        rolledDieNum ++;
                        int dieRoll = (int)(Math.random()*6)+1;
                        drawDice(graphicsContext,dieRoll,(int) canvas.getWidth()-80,20);
                    }
                    break;
                case 2:
                    if(!dieInQ3){
                        dieInQ3=true;
                        rolledDieNum ++;
                        int dieRoll = (int)(Math.random()*6)+1;
                        drawDice(graphicsContext,dieRoll,(int)canvas.getWidth()-80,(int)canvas.getHeight()-80);
                    }
                    break;
                case 3:
                    if(!dieInQ4){
                        dieInQ4=true;
                        rolledDieNum ++;
                        int dieRoll = (int)(Math.random()*6)+1;
                        drawDice(graphicsContext,dieRoll,20,(int)canvas.getHeight()-80);
                    }
                    break;
            }
        }
    }



    public static void main (String[] Args){
        launch(Args);
    }
}
