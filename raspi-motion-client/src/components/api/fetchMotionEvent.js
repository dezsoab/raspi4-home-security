export const fetchMotionEvent = async (pageAmount, limitAmount) => {
  const res = await fetch(
    `http://192.168.0.27:8080/api/v1/pageable?page=${pageAmount}&limit=${limitAmount}`,
  );
  const data = await res.json();
  return data;
};
