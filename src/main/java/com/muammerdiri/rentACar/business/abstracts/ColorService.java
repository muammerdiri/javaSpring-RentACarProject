package com.muammerdiri.rentACar.business.abstracts;

import com.muammerdiri.rentACar.core.utilities.result.Result;
import com.muammerdiri.rentACar.entities.concrete.Color;

import java.util.List;

public interface ColorService {
    Result add(Color color);
    Result delete(Color color);

    List<Color> getAll();
}
