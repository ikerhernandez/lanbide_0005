package com.ipartek.formacion.mf0967.uf2216.poo.presentacion;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Balon;
import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Comestible;
import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Naranja;
import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Rodable;

public class EjemploInterfaces {

	public static void main(String[] args) {
		List<Rodable> rodables = new ArrayList<>();
		
		rodables.add(new Balon());
		rodables.add(new Naranja());
		
		
		for (Rodable r: rodables) {
			if(r instanceof Comestible) {
				((Comestible) r).comer();
			}
			
			r.rodar();
			
			if(r instanceof Comestible) {
				Comestible c = (Comestible) r;
				c.comer();
			}
		}

	}

}
