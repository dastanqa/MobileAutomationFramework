package com.dastancompany.facade;

import com.dastancompany.pages.DragAndDropPageNative;
import com.dastancompany.pages.HomePageNative;

public class DragDropFacade {

    public DragDropFacade navigateToDragAndDropPage(){
        new HomePageNative().clickOnViews().clickMenuItem("Drag and Drop");
        return this;
    }

    public DragAndDropPageNative getDragAndDropPage(){
        return new DragAndDropPageNative();
    }
}
