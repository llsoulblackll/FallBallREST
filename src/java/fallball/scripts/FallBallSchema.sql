
--CREATE TABLE PlayerData
--(
--    PlayerId INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
--    PlayerName VARCHAR(200),
--    PlayerScore FLOAT,
--    Level INT
--);

CREATE TABLE Player
(
    PlayerId INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    PlayerName VARCHAR(200),
    PlayerScore FLOAT,
    Level INT
);

CREATE TABLE DeviceInfo
(
    DeviceId VARCHAR(300),
    Platform VARCHAR(200),
    OS VARCHAR(200)
);
