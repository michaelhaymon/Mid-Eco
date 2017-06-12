package com.haywire_gaming.mid_eco;

import java.util.ArrayList;

public class Validation {

	public boolean isCoupleFertile(Person mother, Person father) {
		if (!(mother.getSex().equals(father.getSex()))) {
			if (mother.isFertile() && father.isFertile()) {
				return true;
			}
		}
		// Couple is infertile.
		return false;
	}

	public boolean isCoupleInbreeding(Person mother, Person father) {

		final ArrayList<Person> motherFamily = new ArrayList<Person>();
		final ArrayList<Person> fatherFamily = new ArrayList<Person>();

		motherFamily.addAll(mother.getParents());
		motherFamily.addAll(mother.getSiblings());

		fatherFamily.addAll(father.getParents());
		fatherFamily.addAll(father.getSiblings());

		for (int i = 0; i < fatherFamily.size(); i++) {
			if (motherFamily.contains(fatherFamily.get(i))) {
				// Incest.
				return true;
			}
		}
		// Not incest.
		return false;
	}
}
