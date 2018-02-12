package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.util.ArrayList;

import com.ipartek.formacion.ejemplocapas.entidades.Factura;

public class DAOFacturaArrayList implements DAOFactura{

	private ArrayList<Factura> facturas = new ArrayList<Factura>();
	
	
	@Override
	public void alta(Factura factura) {
		if(obtenerFacturaPorId(factura.getId()) == null) {
			facturas.add(factura);
		}else {
			throw new AccesoDatosException(
					"Ya existe ese Factura con id = " + 
							factura.getId());
		}
	}

	@Override
	public void baja(Factura factura) {
		facturas.remove(factura);
		
	}

	@Override
	public void modificacion(Factura factura) {
		Factura f = obtenerFacturaPorId(factura.getId());
		
		if(f != null) {
			f.setC(factura.getC());
			f.setFecha(factura.getFecha());
			f.setIva(factura.getIva());
			f.setTotalConIva(factura.getTotalConIva());
			f.setTotalSinIva(factura.getTotalSinIva());
			f.setU(factura.getU());
		}else {
			throw new AccesoDatosException("No existe el producto a modificar");
		}
		
	}

	@Override
	public Factura[] obtenerFacturas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Factura obtenerFacturaPorId(long id) {
		Factura f;
		for(int i=0; i < facturas.size(); i++) {
			 f = facturas.get(i);
			 
			 if(f.getId()==id)
				 return f;
		}
		return null;
	}

	
	
}
