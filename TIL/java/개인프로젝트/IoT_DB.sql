drop table TimeReservation ;

-- 사용자 정보 테이블 생성
CREATE TABLE Users (
    User_ID VARCHAR2(100)  PRIMARY KEY,           -- 사용자 ID
    Password VARCHAR2(50),                -- 비밀번호
    NAME VARCHAR2(100)                   -- 사용자 이름
);


-- 디바이스 정보 테이블 생성
CREATE TABLE DeviceInfo (
    Device_ID VARCHAR2(100) PRIMARY KEY,          -- 디바이스 ID
    Manufacture VARCHAR2(100),            -- 디바이스 제조사
    D_type VARCHAR2(100),               --종류
    Regist_Date DATE,                      -- 디바이스 등록 일시
    Status VARCHAR2(10),                   -- 디바이스 On/Off 상태
    Room_Name VARCHAR2(100),               -- 디바이스가 설치된 방 이름
    User_ID VARCHAR2(100),                        -- 외래 키: 사용자 테이블의 User_ID와 연결 (등록한 사용자)
    FOREIGN KEY (User_ID) REFERENCES Users(User_ID) -- 사용자 정보 테이블과의 외래 키 제약
);

-- 시간 예약 테이블 생성
CREATE TABLE TimeReservation (
    Reservation_ID NUMBER PRIMARY KEY,     -- 예약 ID
    Device_ID VARCHAR2(100),                      -- 디바이스 ID
    Start_Time TIMESTAMP,                  -- 시작 시간
    End_Time TIMESTAMP,                    -- 종료 시간
    FOREIGN KEY (Device_ID) REFERENCES DeviceInfo(Device_ID) -- 디바이스 정보 테이블과의 외래 키 제약
);

-- 활동 로그 테이블 생성
CREATE TABLE ActivityLog (
    Log_ID NUMBER PRIMARY KEY,             -- 로그 ID
    User_ID VARCHAR2(100),                        -- 사용자 ID
    Device_ID VARCHAR2(100),                      -- 디바이스 ID
    Timestamp TIMESTAMP,                   -- 로그 작성 시간
    Status VARCHAR2(10),                   -- 전원 상태 (On/Off)
    FOREIGN KEY (User_ID) REFERENCES Users(User_ID),      
    FOREIGN KEY (Device_ID) REFERENCES DeviceInfo(Device_ID)
);

-- 사용자 정보 테이블에 데이터 삽입
INSERT INTO Users (User_ID, Password, Name) VALUES ('daddy123', '1234', '김덕배');
INSERT INTO Users (User_ID, Password, Name) VALUES ('momstouch', '2345', '이춘식');
INSERT INTO Users (User_ID, Password, Name) VALUES ('myson', '3456', '우리손');
INSERT INTO Users (User_ID, Password, Name) VALUES ('danger', '4567', '금사월');

-- 디바이스 정보 테이블에 데이터 삽입
INSERT INTO DeviceInfo (Device_ID, Manufacture, D_type, Regist_Date, Status, Room_Name, User_ID)
VALUES ('거실티비', 'Samsung', 'TV', TO_DATE('2023-08-10', 'YYYY-MM-DD'), 'Off', '거실', 'daddy123');
INSERT INTO DeviceInfo (Device_ID, Manufacture, D_type, Regist_Date, Status, Room_Name, User_ID)
VALUES ('거실에어컨', 'Samsung', '에어컨', TO_DATE('2024-01-17', 'YYYY-MM-DD'), 'Off', '거실', 'momstouch');
INSERT INTO DeviceInfo (Device_ID, Manufacture, D_type, Regist_Date, Status, Room_Name, User_ID)
VALUES ('스탠바이미', 'LG', '모니터', TO_DATE('2021-05-27', 'YYYY-MM-DD'), 'On', '안방', 'myson');
INSERT INTO DeviceInfo (Device_ID, Manufacture, D_type, Regist_Date, Status, Room_Name, User_ID)
VALUES ('무드등', '한샘', '전등', TO_DATE('2023-11-19', 'YYYY-MM-DD'), 'Off', '작은방', 'danger');
INSERT INTO DeviceInfo (Device_ID, Manufacture, D_type, Regist_Date, Status, Room_Name, User_ID)
VALUES ('작은방에어컨', 'Samsung', '에어컨', TO_DATE('2023-07-20', 'YYYY-MM-DD'), 'Off', '작은방', 'danger');
INSERT INTO DeviceInfo (Device_ID, Manufacture, D_type, Regist_Date, Status, Room_Name, User_ID)
VALUES ('안방티비', 'LG', 'TV', TO_DATE('2023-06-01', 'YYYY-MM-DD'), 'Off', '거실', 'momstouch');

-- 시간 예약 테이블에 데이터 삽입
INSERT INTO TimeReservation (Reservation_ID, Device_ID, Start_Time, End_Time)
VALUES (1, '거실에어컨', TO_TIMESTAMP('2024-04-11 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-04-11 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));

-- 활동 로그 테이블에 데이터 삽입
INSERT INTO ActivityLog (Log_ID, User_ID, Device_ID, Timestamp, Status)
VALUES (101, 'danger', '무드등', TO_TIMESTAMP('2024-04-10 08:05:50', 'YYYY-MM-DD HH24:MI:SS'), 'On');
INSERT INTO ActivityLog (Log_ID, User_ID, Device_ID, Timestamp, Status)
VALUES (102, 'daddy123', '거실티비', TO_TIMESTAMP('2024-04-10 10:23:48', 'YYYY-MM-DD HH24:MI:SS'), 'On');
INSERT INTO ActivityLog (Log_ID, User_ID, Device_ID, Timestamp, Status)
VALUES (103, 'daddy123', '거실티비', TO_TIMESTAMP('2024-04-10 13:32:21', 'YYYY-MM-DD HH24:MI:SS'), 'Off');
INSERT INTO ActivityLog (Log_ID, User_ID, Device_ID, Timestamp, Status)
VALUES (104, 'daddy123', '거실티비', TO_TIMESTAMP('2024-04-10 15:28:13', 'YYYY-MM-DD HH24:MI:SS'), 'On');
INSERT INTO ActivityLog (Log_ID, User_ID, Device_ID, Timestamp, Status)
VALUES (105, 'danger', '무드등', TO_TIMESTAMP('2024-04-10 16:45:17', 'YYYY-MM-DD HH24:MI:SS'), 'Off');
INSERT INTO ActivityLog (Log_ID, User_ID, Device_ID, Timestamp, Status)
VALUES (106, 'daddy123', '거실티비', TO_TIMESTAMP('2024-04-10 18:01:24', 'YYYY-MM-DD HH24:MI:SS'), 'Off');

--예약번호 자동시퀀스
CREATE SEQUENCE reservation_id_seq START WITH 1 INCREMENT BY 1;
INSERT INTO TimeReservation (Reservation_ID, Device_ID, Start_Time, End_Time)
VALUES (reservation_id_seq.NEXTVAL, '작은방에어컨', 
TO_TIMESTAMP('2024-04-10 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-04-10 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));


--로그 번호 자동시퀀스
CREATE SEQUENCE log_id_seq START WITH 107 INCREMENT BY 1;
INSERT INTO ActivityLog (Log_ID, User_ID, Device_ID, Timestamp, Status)
VALUES (log_id_seq.NEXTVAL, 'danger', '무드등', TO_TIMESTAMP('2024-04-10 08:05:50', 'YYYY-MM-DD HH24:MI:SS'), 'On');

select*from users;
select*from deviceinfo;
select*from TimeReservation order by 1;
select*from ActivityLog order by 1;

commit;

--로그인
select password
from users
where user_id=?
and password=?;

UPDATE TimeReservation
SET End_Time = TO_TIMESTAMP('2024-04-12 13:11:11', 'YYYY-MM-DD HH24:MI:SS')
WHERE Reservation_ID = 1;

update deviceInfo
set status = 'On'
where device_id = '작은방에어컨';

--타임스탬프 밀리초 삭제 
SELECT TO_CHAR(start_time, 'YYYY-MM-DD HH24:MI:SS'),TO_CHAR(end_time, 'YYYY-MM-DD HH24:MI:SS') AS formatted_timestamp
FROM TimeReservation;


select Device_ID as 기기ID, 
Manufacture as 제조사, 
D_type as 종류, 
Regist_Date as 등록일, 
Status as 상태, 
Room_Name as 위치, 
User_ID as 등록자
from deviceinfo;

select device_id, Manufacture, D_type, Regist_Date, Status, Room_Name, User_ID
from deviceinfo;

update deviceinfo set status = 'On'
where device_id = '거실티비';

drop trigger deviceinfo_status_change_trigger;

-- 전원상태 받아오는 트리거
CREATE OR REPLACE TRIGGER deviceinfo_status
AFTER UPDATE OF Status ON DeviceInfo
FOR EACH ROW
BEGIN
    IF :OLD.Status <> :NEW.Status THEN 
        INSERT INTO ActivityLog (Log_ID, User_ID, Device_ID, Timestamp, Status)
        VALUES (log_id_seq.NEXTVAL, :OLD.USER_ID, :OLD.Device_ID, CURRENT_TIMESTAMP, :NEW.Status);
    END IF;
END;
/











