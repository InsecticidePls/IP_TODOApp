package com.insecticidepls.iptodo.data.models

import androidx.compose.ui.graphics.Color
import com.insecticidepls.iptodo.ui.theme.criticalColor
import com.insecticidepls.iptodo.ui.theme.highColor
import com.insecticidepls.iptodo.ui.theme.normalColor
import com.insecticidepls.iptodo.ui.theme.lowColor
import com.insecticidepls.iptodo.ui.theme.noneColor

enum class Priority
    (val color: Color){
        CRITICAL(criticalColor),
        HIGH(highColor),
        NORMAL(normalColor),
        LOW(lowColor),
        NONE(noneColor)
}
