package com.example.application.views.grid;

import com.example.application.views.main.MainView;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Person Grid")
@Route(value = "grid", layout = MainView.class)
@RouteAlias(value = "person_grid", layout = MainView.class)
@CssImport(value = "./styles/views/grid/grid-view.css")
@CssImport(value = "./styles/views/grid/person-grid-view.css", themeFor = "vaadin-grid")
public class GridView extends VerticalLayout {

    public GridView() {

        PersonGrid personGrid = new PersonGrid();
        personGrid.setClassName("person-grid");
        add(personGrid);

        setSizeFull();
        getElement().getStyle().set("min-height", "500px");

    }

}
