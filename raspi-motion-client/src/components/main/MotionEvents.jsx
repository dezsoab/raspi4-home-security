const MotionEvents = ({ events, dataIsLoaded }) => {
  return (
    <>
      <h2>-- motion events --</h2>
      {!dataIsLoaded && <p>Loading events...</p>}
      {dataIsLoaded && (
        <table>
          <thead>
            <tr>
              <th>Event ID</th>
              <th>Date</th>
            </tr>
          </thead>
          <tbody>
            {events.map((event) => (
              <tr key={event.id}>
                <td>{event.id}</td>
                <td>{new Date(event.date).toLocaleString("hu")}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </>
  );
};

export default MotionEvents;
