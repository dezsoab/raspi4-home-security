import React, { useState, useEffect } from "react";
import { fetchMotionEvent } from "../api/fetchMotionEvent";

import MotionEvents from "./MotionEvents";
import classes from "./Main.module.css";
import AdjustData from "./AdjustData";

const Main = () => {
  const [events, setEvents] = useState();
  const [dataIsLoaded, setDataIsLoaded] = useState(false);

  useEffect(() => {
    setDataIsLoaded(false);
    (async () => {
      const initialPage = 0;
      const initialLimit = 5;
      const data = await fetchMotionEvent(initialPage, initialLimit);
      setEvents(data);
      setDataIsLoaded(true);
    })();
  }, []);

  return (
    <div className={classes.main}>
      <h1>Home Security</h1>
      <p>Welcome, Dezso 💡</p>
      <MotionEvents dataIsLoaded={dataIsLoaded} events={events} />
      <AdjustData setEvents={setEvents} />
    </div>
  );
};

export default Main;
