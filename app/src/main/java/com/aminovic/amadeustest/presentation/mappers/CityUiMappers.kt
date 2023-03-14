package com.aminovic.amadeustest.presentation.mappers

import com.aminovic.amadeustest.R
import com.aminovic.amadeustest.domain.modal.City
import com.aminovic.amadeustest.presentation.modal.CityUi


fun City.toCityUi(): CityUi {
    return CityUi(
        cityId = cityId,
        cityName = cityName,
        findName = findName,
        country = country?.let { getRes(it) },
        lon = lon,
        lat = lat,
        zoom = zoom,
        time = time,
        temp = temp,
        pressure = pressure,
        humidity = humidity,
        tempMin = tempMin,
        tempMax = tempMax,
        windSpeed = windSpeed,
        windDeg = windDeg,
        windVarBeg = windVarBeg,
        windVarEnd = windVarEnd,
        clouds = clouds,
        rain = rain,
        weather = weather,
        image = -1
    )
}

fun getRes(country: String): Int {
    return when (country) {
        "AF" -> {
            R.drawable.af
        }
        "AL" -> {
            R.drawable.al
        }
        "DZ" -> {
            R.drawable.dz
        }
        "AD" -> {
            R.drawable.ad
        }
        "AO" -> {
            R.drawable.ao
        }
        "AR" -> {
            R.drawable.ar
        }
        "AM" -> {
            R.drawable.am
        }
        "AW" -> {
            R.drawable.aw
        }
        "AU" -> {
            R.drawable.au
        }
        "AT" -> {
            R.drawable.at
        }
        "AZ" -> {
            R.drawable.az
        }
        "BH" -> {
            R.drawable.bh
        }
        "BD" -> {
            R.drawable.bd
        }
        "BY" -> {
            R.drawable.by
        }
        "BE" -> {
            R.drawable.be
        }
        "BZ" -> {
            R.drawable.bz
        }
        "BJ" -> {
            R.drawable.bj
        }
        "BT" -> {
            R.drawable.bt
        }
        "BO" -> {
            R.drawable.bo
        }
        "BA" -> {
            R.drawable.bo
        }
        "BW" -> {
            R.drawable.bw
        }
        "BR" -> {
            R.drawable.br
        }
        "BN" -> {
            R.drawable.bn
        }
        "BG" -> {
            R.drawable.bg
        }
        "BF" -> {
            R.drawable.bf
        }
        "MM" -> {
            R.drawable.mm
        }
        "BI" -> {
            R.drawable.bi
        }
        "KH" -> {
            R.drawable.kh
        }
        "CM" -> {
            R.drawable.cm
        }
        "CA" -> {
            R.drawable.ca
        }
        "CV" -> {
            R.drawable.cv
        }
        "CF" -> {
            R.drawable.cf
        }
        "TD" -> {
            R.drawable.td
        }
        "CL" -> {
            R.drawable.cl
        }
        "CN" -> {
            R.drawable.cn
        }
        "CX" -> {
            R.drawable.cx
        }
        "CC" -> {
            R.drawable.cc
        }
        "CO" -> {
            R.drawable.co
        }
        "KM" -> {
            R.drawable.km
        }
        "CG" -> {
            R.drawable.cg
        }
        "CD" -> {
            R.drawable.cd
        }
        "CK" -> {
            R.drawable.ck
        }
        "CR" -> {
            R.drawable.cr
        }
        "HR" -> {
            R.drawable.hr
        }
        "CU" -> {
            R.drawable.cu
        }
        "CY" -> {
            R.drawable.cy
        }
        "CZ" -> {
            R.drawable.cz
        }
        "DK" -> {
            R.drawable.dk
        }
        "DJ" -> {
            R.drawable.dj
        }
        "TL" -> {
            R.drawable.tl
        }
        "EC" -> {
            R.drawable.ec
        }
        "EG" -> {
            R.drawable.eg
        }
        "SV" -> {
            R.drawable.sv
        }
        "GQ" -> {
            R.drawable.gq
        }
        "ER" -> {
            R.drawable.er
        }
        "EE" -> {
            R.drawable.ee
        }
        "ET" -> {
            R.drawable.et
        }
        "FK" -> {
            R.drawable.fk
        }
        "FO" -> {
            R.drawable.fo
        }
        "FJ" -> {
            R.drawable.fj
        }
        "FI" -> {
            R.drawable.fi
        }
        "FR" -> {
            R.drawable.fr
        }
        "PF" -> {
            R.drawable.pf
        }
        "GA" -> {
            R.drawable.ga
        }
        "GM" -> {
            R.drawable.gm
        }
        "GE" -> {
            R.drawable.ge
        }
        "DE" -> {
            R.drawable.de
        }
        "GH" -> {
            R.drawable.gh
        }
        "GI" -> {
            R.drawable.gi
        }
        "GR" -> {
            R.drawable.gr
        }
        "GL" -> {
            R.drawable.gl
        }
        "GT" -> {
            R.drawable.gt
        }
        "GN" -> {
            R.drawable.gn
        }
        "GW" -> {
            R.drawable.gw
        }
        "GY" -> {
            R.drawable.gy
        }
        "HT" -> {
            R.drawable.ht
        }
        "HN" -> {
            R.drawable.hn
        }
        "HK" -> {
            R.drawable.hk
        }
        "HU" -> {
            R.drawable.hu
        }
        "IN" -> {
            R.drawable.`in`
        }
        "ID" -> {
            R.drawable.id
        }
        "IR" -> {
            R.drawable.ir
        }
        "IQ" -> {
            R.drawable.iq
        }
        "IE" -> {
            R.drawable.ie
        }
        "IM" -> {
            R.drawable.im
        }
        "IL" -> {
            R.drawable.dz
        }
        "IT" -> {
            R.drawable.it
        }
        "CI" -> {
            R.drawable.ci
        }
        "JP" -> {
            R.drawable.jp
        }
        "JO" -> {
            R.drawable.jo
        }
        "KZ" -> {
            R.drawable.kz
        }
        "KE" -> {
            R.drawable.ke
        }
        "KI" -> {
            R.drawable.ki
        }
        "KW" -> {
            R.drawable.kw
        }
        "KG" -> {
            R.drawable.kg
        }
        "LA" -> {
            R.drawable.la
        }
        "LV" -> {
            R.drawable.lv
        }
        "LB" -> {
            R.drawable.lb
        }
        "LS" -> {
            R.drawable.ls
        }
        "LR" -> {
            R.drawable.lr
        }
        "LY" -> {
            R.drawable.ly
        }
        "LI" -> {
            R.drawable.li
        }
        "LT" -> {
            R.drawable.lt
        }
        "LU" -> {
            R.drawable.lu
        }
        "MO" -> {
            R.drawable.mo
        }
        "MK" -> {
            R.drawable.mk
        }
        "MG" -> {
            R.drawable.mg
        }
        "MW" -> {
            R.drawable.mw
        }
        "MY" -> {
            R.drawable.my
        }
        "MV" -> {
            R.drawable.mv
        }
        "ML" -> {
            R.drawable.ml
        }
        "MT" -> {
            R.drawable.mt
        }
        "MH" -> {
            R.drawable.mh
        }
        "MR" -> {
            R.drawable.mr
        }
        "MU" -> {
            R.drawable.mu
        }
        "YT" -> {
            R.drawable.yt
        }
        "MX" -> {
            R.drawable.mx
        }
        "FM" -> {
            R.drawable.fm
        }
        "MD" -> {
            R.drawable.md
        }
        "MC" -> {
            R.drawable.mc
        }
        "MN" -> {
            R.drawable.mn
        }
        "ME" -> {
            R.drawable.me
        }
        "MA" -> {
            R.drawable.ma
        }
        "MZ" -> {
            R.drawable.mz
        }
        "NA" -> {
            R.drawable.na
        }
        "NR" -> {
            R.drawable.nr
        }
        "NP" -> {
            R.drawable.np
        }
        "NL" -> {
            R.drawable.nl
        }
        "AN" -> {
            R.drawable.an
        }
        "NC" -> {
            R.drawable.nc
        }
        "NZ" -> {
            R.drawable.nz
        }
        "NI" -> {
            R.drawable.ni
        }
        "NE" -> {
            R.drawable.ne
        }
        "NG" -> {
            R.drawable.ng
        }
        "NU" -> {
            R.drawable.nu
        }
        "KP" -> {
            R.drawable.kp
        }
        "NO" -> {
            R.drawable.no
        }
        "OM" -> {
            R.drawable.om
        }
        "PK" -> {
            R.drawable.pk
        }
        "PW" -> {
            R.drawable.pw
        }
        "PA" -> {
            R.drawable.pa
        }
        "PG" -> {
            R.drawable.pg
        }
        "PY" -> {
            R.drawable.py
        }
        "PE" -> {
            R.drawable.pe
        }
        "PH" -> {
            R.drawable.ph
        }
        "PN" -> {
            R.drawable.pn
        }
        "PL" -> {
            R.drawable.pl
        }
        "PT" -> {
            R.drawable.pt
        }
        "PR" -> {
            R.drawable.pr
        }
        "QA" -> {
            R.drawable.qa
        }
        "RO" -> {
            R.drawable.ro
        }
        "RU" -> {
            R.drawable.ru
        }
        "RW" -> {
            R.drawable.rw
        }
        "BL" -> {
            R.drawable.bl
        }
        "WS" -> {
            R.drawable.ws
        }
        "SM" -> {
            R.drawable.sm
        }
        "ST" -> {
            R.drawable.st
        }
        "SA" -> {
            R.drawable.sa
        }
        "SN" -> {
            R.drawable.sn
        }
        "RS" -> {
            R.drawable.rs
        }
        "SC" -> {
            R.drawable.sc
        }
        "SL" -> {
            R.drawable.sl
        }
        "SG" -> {
            R.drawable.sg
        }
        "SK" -> {
            R.drawable.sk
        }
        "SI" -> {
            R.drawable.si
        }
        "SB" -> {
            R.drawable.sb
        }
        "SO" -> {
            R.drawable.so
        }
        "ZA" -> {
            R.drawable.za
        }
        "KR" -> {
            R.drawable.kr
        }
        "ES" -> {
            R.drawable.es
        }
        "LK" -> {
            R.drawable.lk
        }
        "SH" -> {
            R.drawable.sh
        }
        "PM" -> {
            R.drawable.pm
        }
        "SD" -> {
            R.drawable.sd
        }
        "SR" -> {
            R.drawable.sr
        }
        "SZ" -> {
            R.drawable.sz
        }
        "SE" -> {
            R.drawable.se
        }
        "CH" -> {
            R.drawable.ch
        }
        "SY" -> {
            R.drawable.sy
        }
        "TW" -> {
            R.drawable.tw
        }
        "TJ" -> {
            R.drawable.tj
        }
        "TZ" -> {
            R.drawable.tz
        }
        "TH" -> {
            R.drawable.th
        }
        "TG" -> {
            R.drawable.tg
        }
        "TK" -> {
            R.drawable.tk
        }
        "TO" -> {
            R.drawable.to
        }
        "TN" -> {
            R.drawable.tn
        }
        "TR" -> {
            R.drawable.tr
        }
        "TM" -> {
            R.drawable.tm
        }
        "TV" -> {
            R.drawable.tv
        }
        "AE" -> {
            R.drawable.ae
        }
        "UG" -> {
            R.drawable.ug
        }
        "GB" -> {
            R.drawable.gb
        }
        "UA" -> {
            R.drawable.ua
        }
        "UY" -> {
            R.drawable.uy
        }
        "US" -> {
            R.drawable.us
        }
        "UZ" -> {
            R.drawable.uz
        }
        "VU" -> {
            R.drawable.vu
        }
        "VA" -> {
            R.drawable.va
        }
        "VE" -> {
            R.drawable.ve
        }
        "VN" -> {
            R.drawable.vn
        }
        "WF" -> {
            R.drawable.wf
        }
        "YE" -> {
            R.drawable.ye
        }
        "ZM" -> {
            R.drawable.zm
        }
        "ZW" -> {
            R.drawable.zw
        }
        else -> {
            R.drawable.dz
        }
    }
}