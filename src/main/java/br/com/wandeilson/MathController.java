package br.com.wandeilson;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wandeilson.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)//Usando RequestMapping generico
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo))   {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico.");
		}
		return convertToDouble(numberOne) + convertToDouble(numberTwo); 
	}
	@GetMapping("/sub/{numberOne}/{numberTwo}") //Usando GetMapping especifico
	public double sub ( @PathVariable (value = "numberOne") String numberOne,
			@PathVariable (value = "numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo))   {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico.");
		}
		return convertToDouble(numberOne) - convertToDouble(numberTwo);	
	}
	
	@GetMapping("/multi/{numberOne}/{numberTwo}") //Usando GetMapping especifico
	public double multi ( @PathVariable (value = "numberOne") String numberOne,
			@PathVariable (value = "numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo))   {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico.");
		}
		return convertToDouble(numberOne) * convertToDouble(numberTwo);	
	}
	
	@GetMapping("/div/{numberOne}/{numberTwo}") //Usando GetMapping especifico
	public double div ( @PathVariable (value = "numberOne") String numberOne,
			@PathVariable (value = "numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo))   {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico.");
		}
		return convertToDouble(numberOne) / convertToDouble(numberTwo);	
	}
	
	@GetMapping("/avrg/{numberOne}/{numberTwo}") //Usando GetMapping especifico
	public double avrg ( @PathVariable (value = "numberOne") String numberOne,
			@PathVariable (value = "numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo))   {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico.");
		}
		return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;	
	}
	
	@GetMapping("/sqrt/{number}") //Usando GetMapping especifico
	public double sqrt ( @PathVariable (value = "number") String number) throws Exception {
		
		if(!isNumeric(number))   {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico.");
		}
		return Math.sqrt(convertToDouble(number));
	}
	

	
	

	private double convertToDouble(String strNumber) throws Exception {
		if(strNumber == null) throw new Exception("Invalid number");
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		throw new Exception("Invalid number");
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		try {
			double numeric = Double.parseDouble(number);
			} catch(NumberFormatException e) {
				return false;
			}
		return true;
	}
}







