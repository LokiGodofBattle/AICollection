package de.loki.aicollection;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Loki on 21.05.2018.
 */

public class SimulationScreen implements Screen {

    public static float gridWidth;
    private Main mainClass;
    public Array<Tile> grid;
    public static float tileAmountX;
    public static float tileAmountY;

    public SimulationScreen(Main mainClass){
        gridWidth = 3;
        tileAmountX = 32;
        tileAmountY = 18;
        this.mainClass = mainClass;
        grid = new Array<Tile>();

        inizialiseGrid();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Vector3 mouse = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);

        Main.camera.unproject(mouse);

        for(int i = 0; i<grid.size; i++){
            grid.get(i).render(new Vector2(mouse.x, mouse.y));
        }

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainClass.shapeRenderer.setProjectionMatrix(Main.camera.combined);
        mainClass.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for(int i = 0; i<grid.size; i++){
            grid.get(i).draw(mainClass.shapeRenderer);
        }

        mainClass.shapeRenderer.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void inizialiseGrid(){

        for(int i = 0; i<tileAmountX; i++){
            for(int j = 0; j<tileAmountY; j++){
                grid.add(new Tile(i, j, Main.VIEWPORT_WIDTH/tileAmountX));
            }
        }

    }

}
