package utilities;

import apiClasses.LibraryApp;

public class ManageApiObjects
{

    private LibraryApp libraryApp = null;

    public LibraryApp getLibraryApp()
    {
        return (libraryApp == null) ? libraryApp = new LibraryApp() : libraryApp;
    }
}
