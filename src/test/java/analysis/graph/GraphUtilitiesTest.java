package analysis.graph;

import java.math.BigDecimal;
import java.math.MathContext;

import org.junit.Assert;
import org.junit.Test;

public class GraphUtilitiesTest
{
	@Test
	public void testCalculateEuclideanDistance_IntegerResult()
	{
		// Arrange
		BigDecimal resultExpected = new BigDecimal("5");
		
		Point point1 = new Point(new BigDecimal("0"), new BigDecimal("0"));
		Point point2 = new Point(new BigDecimal("3"), new BigDecimal("4"));
		
		// Act
		BigDecimal resultActual = GraphUtilities.calculateEuclideanDistance(point1, point2);
		
		// Assert
		Assert.assertTrue(resultExpected.compareTo(resultActual) == 0);
	}
	
	@Test
	public void testCalculateEuclideanDistance_FloatingPointResult()
	{
		// Arrange
		BigDecimal resultExpected = new BigDecimal("6.40312");
		
		Point point1 = new Point(new BigDecimal("0"), new BigDecimal("0"));
		Point point2 = new Point(new BigDecimal("4"), new BigDecimal("5"));
		
		// Act
		BigDecimal resultActual = GraphUtilities.calculateEuclideanDistance(point1, point2);
		MathContext context = new MathContext(6);
		BigDecimal resultActualRounded = resultActual.round(context);
		
		// Assert
		Assert.assertTrue(resultExpected.compareTo(resultActualRounded) == 0);
	}
}
