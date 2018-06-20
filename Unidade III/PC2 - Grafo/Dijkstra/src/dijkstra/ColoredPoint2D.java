/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

/**
 *
 * @author Sidnei
 */
import java.awt.Color;

// A colored point in the plane
public class ColoredPoint2D {
	double x, y; // coordinates
	int r; // radius
	Color color; // color
	
	ColoredPoint2D(double x, double y, int r, Color color) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.color = color;
	}
}
