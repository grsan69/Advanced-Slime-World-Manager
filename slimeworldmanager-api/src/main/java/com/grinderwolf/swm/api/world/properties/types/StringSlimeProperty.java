package com.grinderwolf.swm.api.world.properties.types;

import com.flowpowered.nbt.StringTag;
import com.grinderwolf.swm.api.world.properties.PropertyType;

import java.util.function.Function;

public class StringSlimeProperty extends SlimeProperty<String> {
    public StringSlimeProperty(String nbtName, String defaultValue) {
        this(nbtName, defaultValue, null);
    }

    public StringSlimeProperty(String nbtName, String defaultValue, Function<String, Boolean> validator) {
        super(nbtName, PropertyType.STRING, defaultValue, validator,
                (value, parent, self) -> parent.put(self.getNbtName(), new StringTag(self.getNbtName(), value)),
                (parent, self) -> parent.getStringValue(self.getNbtName()).orElse(self.getDefaultValue())
        );
    }
}