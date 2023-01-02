import React, { useRef } from "react";
import { fetchMotionEvent } from "../api/fetchMotionEvent";

const AdjustData = ({ setEvents }) => {
  const pageAmount = useRef();
  const limitAmount = useRef();

  const onSubmitHandler = async (e) => {
    e.preventDefault();
    const pageValue = pageAmount.current.value;
    const limitValue = limitAmount.current.value;
    const data = await fetchMotionEvent(pageValue, limitValue);
    setEvents(data);
  };

  return (
    <>
      <h4>% modify loaded data amount %</h4>
      <form onSubmit={onSubmitHandler}>
        <label htmlFor="page">Page Nr.</label>
        <input
          type="number"
          name="page"
          id="page"
          min="0"
          defaultValue="0"
          ref={pageAmount}
        />
        <label htmlFor="limit">Limit Nr.</label>
        <input
          type="number"
          name="limit"
          id="limit"
          min="1"
          defaultValue="5"
          ref={limitAmount}
        />
        <button>Refresh data</button>
      </form>
    </>
  );
};

export default AdjustData;
