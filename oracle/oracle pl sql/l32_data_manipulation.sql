select to_char(sysdate, 'HH24:MI:SS DD.MM.YYYY') as now_time, 
        to_char(sysdate+1, 'HH24:MI:SS DD.MM.YYYY') as tomorrow_next_day,
        to_char(sysdate+7, 'HH24:MI:SS DD.MM.YYYY') as seven_days_from_now,
        to_char(sysdate+1/24, 'HH24:MI:SS DD.MM.YYYY') as one_hour_from_now,
        to_char(sysdate+3/24, 'HH24:MI:SS DD.MM.YYYY') as three_hour_from_now,
        to_char(sysdate+1/48, 'HH24:MI:SS DD.MM.YYYY') as half_hour_from_now,
        to_char(sysdate+10/1440, 'HH24:MI:SS DD.MM.YYYY') as ten_min_from_now,
        to_char(sysdate+30/86400, 'HH24:MI:SS DD.MM.YYYY') as thirty_sec_from_now
from dual;