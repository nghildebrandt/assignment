class Painting {
	String typeOfPaint;
	boolean impressionism;
	int yearPainted;
	final static int IS_MODERN_YEAR = 1900;

	boolean isModern() {
		return yearPainted > IS_MODERN_YEAR;
	}
	boolean oilAndImpressionist() {
		return impressionism && typeOfPaint.equals("oil");
	}
}

class Gallery {
	String name;
	Painting[] paintingArray;//specified that it is already initialized
	int numberOfPaintings;
	final static double POPULAR_BORDER = 60;
	final static double MAJORITY_BORDER = 0.50;

	Gallery() {
		numberOfPaintings = 0;//created this myself
	}

	int numberOfModernPaintings() {
		int result = 0;
		for (int i = 0; i < numberOfPaintings; i++) { //not quite sure if I should use the numberOfPaintings that I created
			if (paintingArray[i].isModern()) {
				result += 1;
			}
		}
		return result;
	}

	boolean isModern() {
		return numberOfModernPaintings() / paintingArray.length > MAJORITY_BORDER;
	}
	boolean isPopular() {
		int impressionistAndOil = 0;

		for (int i = 0; i < paintingArray.length; i++) {
			if (paintingArray[i].oilAndImpressionist()) {
				impressionistAndOil += 1;
			}
		}
		double result = impressionistAndOil / paintingArray.length * 100;
		return result > POPULAR_BORDER;
	}
}

class Museum {
	final static int M_N_G = 30;
	Gallery[] galleryArray;
	int numberOfGalleries;

	Museum() {
		galleryArray = new Gallery[M_N_G];
		numberOfGalleries = 0;
	}

	void add(Gallery gallery) {
		galleryArray[numberOfGalleries] = gallery;
		numberOfGalleries += 1;
	}

	Museum modernGalleries() {
		Museum result = new Museum();
		for (int i = 0; i < numberOfGalleries; i++) {
			if (galleryArray[i].isModern()) {
				result.add(galleryArray[i]);
			}
		}
		return result;
	}
	int popularModernGalleries(){
		return modernGalleries().isPopularGalleries();//preexisting method
	}
}