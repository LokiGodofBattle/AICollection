package de.loki.aicollection;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Loki on 21.05.2018.
 */

public class Tile {

    private Vector2 pos;
    private float width;
    public int contentID;
    public Rectangle hitbox;

    public Tile(int x, int y, float width){
        pos = new Vector2(x, y);
        this.width = width;
        contentID = 0;
        hitbox = new Rectangle(pos.x * width, pos.y * width, width, width);
    }

    public void draw(ShapeRenderer shapeRenderer){
        if(contentID == 1) shapeRenderer.setColor(Color.BLUE);
        else shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(hitbox.x + SimulationScreen.gridWidth, hitbox.y + SimulationScreen.gridWidth, width - SimulationScreen.gridWidth*2, width - SimulationScreen.gridWidth*2);
    }

    public void render(Vector2 mouse){
        if(hitbox.contains(mouse) && Gdx.input.justTouched()) contentID = 1;
    }

}
