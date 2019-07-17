package bus.itgds.khadametdz.model;

public class ModelPageImage {
    int pageImage;
    String pageText;

    public ModelPageImage(int pageImage, String pageText) {
        this.pageImage = pageImage;
        this.pageText = pageText;
    }

    public int getPageImage() {
        return pageImage;
    }

    public void setPageImage(int pageImage) {
        this.pageImage = pageImage;
    }

    public String getPageText() {
        return pageText;
    }

    public void setPageText(String pageText) {
        this.pageText = pageText;
    }
}
