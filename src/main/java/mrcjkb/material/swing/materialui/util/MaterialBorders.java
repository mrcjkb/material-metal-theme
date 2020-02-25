package mrcjkb.material.swing.materialui.util;

import javax.swing.plaf.BorderUIResource;
import java.awt.*;

public class MaterialBorders {

	private MaterialBorders() {
	}

	public static BorderUIResource roundedLineColorBorder(Color colorLine){
		if(colorLine == null){
			throw new IllegalArgumentException("The color line is null");
		}
		return roundedLineColorBorder(colorLine, 12);
	}

	public static BorderUIResource roundedLineColorBorder(Color colorLine, int arch){
		if(colorLine == null){
			throw new IllegalArgumentException("The color line is null");
		}
		return new BorderUIResource(new RoundedCornerBorder(colorLine, arch));
	}
}