package ru.atikhomirov.geekbrains.at.pom.base.fragment;

import ru.atikhomirov.geekbrains.at.pom.base.ContentPage;

@FunctionalInterface
public interface IOwnedFragment {
    void setOwner(ContentPage ownerPage);
}
